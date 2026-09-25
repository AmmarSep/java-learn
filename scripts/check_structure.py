#!/usr/bin/env python3
"""Check local Markdown navigation and isolated IntelliJ source roots."""

from pathlib import Path
import re
import sys
from urllib.parse import unquote, urlsplit
import xml.etree.ElementTree as ET


ROOT = Path(__file__).resolve().parents[1]
DOCUMENT_DIRS = ("docs", "lessons", "guides", "examples", "reference", "practice", "scripts", "archive")
LINK = re.compile(r"\[[^\]\n]*\]\(([^\s)]+)(?:\s+\"[^\"]*\")?\)")


def prose(text):
    lines = []
    fence = None
    for line in text.splitlines():
        marker = re.match(r"^\s*(`{3,}|~{3,})", line)
        if marker:
            token = marker.group(1)
            if fence is None:
                fence = token
            elif token[0] == fence[0] and len(token) >= len(fence):
                fence = None
            continue
        if fence is None:
            lines.append(line)
    return "\n".join(lines)


def heading_ids(text):
    anchors = set()
    for line in prose(text).splitlines():
        match = re.match(r"^#{1,6}\s+(.+?)(?:\s+#+)?$", line)
        if not match:
            continue
        heading = re.sub(r"\[([^]]+)\]\([^)]+\)", r"\1", match.group(1))
        heading = re.sub(r"<[^>]+>", "", heading)
        slug = re.sub(r"[^\w\- ]", "", heading.lower()).replace(" ", "-")
        candidate = slug
        suffix = 1
        while candidate in anchors:
            candidate = f"{slug}-{suffix}"
            suffix += 1
        anchors.add(candidate)
    anchors.update(re.findall(r'\bid=["\']([^"\']+)["\']', text))
    return anchors


def check_links(documents):
    errors = []
    checked = 0
    for document in documents:
        text = prose(document.read_text(encoding="utf-8"))
        for match in LINK.finditer(text):
            target = match.group(1)
            url = urlsplit(target)
            if url.scheme or url.netloc:
                continue
            checked += 1
            destination = (document.parent / unquote(url.path)).resolve() if url.path else document
            if not destination.exists():
                errors.append(f"{document}: missing link target {target}")
            elif url.fragment and destination.suffix == ".md":
                anchors = heading_ids(destination.read_text(encoding="utf-8"))
                if unquote(url.fragment) not in anchors:
                    errors.append(f"{document}: missing heading {target}")
    return checked, errors


def ide_path(value, module=None):
    value = value.removeprefix("file://").replace("$PROJECT_DIR$", str(ROOT))
    if module is not None:
        value = value.replace("$MODULE_DIR$", str(module.parent))
    return Path(value).resolve()


def check_modules(sources):
    errors = []
    module_files = []
    source_roots = []
    outputs = []
    registry = ET.parse(ROOT / ".idea/modules.xml")
    for item in registry.findall(".//module"):
        module = ide_path(item.attrib["filepath"])
        module_files.append(module)
        if not module.is_file():
            errors.append(f"Missing registered module: {module}")
            continue
        tree = ET.parse(module)
        roots = [ide_path(node.attrib["url"], module) for node in tree.findall(".//sourceFolder")]
        source_roots.extend(roots)
        for node in tree.findall(".//output"):
            outputs.append(ide_path(node.attrib["url"], module))
        if roots and tree.findall(".//orderEntry[@type='module']"):
            errors.append(f"Standalone example must not depend on sibling modules: {module}")
        if roots and not tree.findall(".//output"):
            errors.append(f"Example needs its own compiler output: {module}")
    expected = {source.parent.resolve() for source in sources}
    if len(source_roots) != len(expected) or set(source_roots) != expected:
        errors.append("IntelliJ must have exactly one source root for each example folder, and no shared source root.")
    if len(set(outputs)) != len(outputs):
        errors.append("IntelliJ compiler output directories must be distinct.")
    if any(not path.is_relative_to(ROOT / ".build") for path in outputs):
        errors.append("Example compiler outputs must stay under .build/.")
    for config in (ROOT / ".run").glob("*.xml"):
        tree = ET.parse(config)
        name = tree.find(".//module").attrib["name"]
        main = tree.find(".//option[@name='MAIN_CLASS_NAME']").attrib["value"]
        if name not in {path.stem for path in module_files} or main not in {path.stem for path in sources}:
            errors.append(f"Run configuration references an unknown module/class: {config}")
    return errors


def main():
    documents = [ROOT / "README.md"]
    for folder in DOCUMENT_DIRS:
        documents.extend(sorted((ROOT / folder).rglob("*.md")))
    checked, errors = check_links(documents)
    lessons = sorted((ROOT / "lessons").rglob("[0-9][0-9]_*.md"))
    numbers = sorted(int(path.name[:2]) for path in lessons)
    if numbers != list(range(1, 72)):
        errors.append("The short course must contain lessons 01–71 exactly once.")
    sources = sorted((ROOT / "examples").rglob("*.java"))
    if not sources or len({path.parent for path in sources}) != len(sources):
        errors.append("Keep exactly one standalone example source in each example folder.")
    guides = sorted((ROOT / "guides").glob("[0-9][0-9]-*.md"))
    if [int(path.name[:2]) for path in guides] != list(range(8)):
        errors.append("The detailed guide must contain phases 00–07 exactly once.")
    errors.extend(check_modules(sources))
    if errors:
        print("\n".join(errors), file=sys.stderr)
        return 1
    print(f"OK: {len(lessons)} lessons, {len(guides)} guides, {len(sources)} isolated examples; "
          f"{checked} local links across {len(documents)} Markdown files.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())