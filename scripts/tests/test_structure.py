import importlib.util
from pathlib import Path
import tempfile
import unittest


ROOT = Path(__file__).resolve().parents[2]
SPEC = importlib.util.spec_from_file_location("check_structure", ROOT / "scripts/check_structure.py")
checker = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(checker)


class NavigationTests(unittest.TestCase):
    def setUp(self):
        (ROOT / ".build").mkdir(exist_ok=True)
        self.directory = tempfile.TemporaryDirectory(prefix="navigation-", dir=ROOT / ".build")
        self.addCleanup(self.directory.cleanup)
        self.root = Path(self.directory.name)

    def test_relative_links_and_duplicate_heading_anchors(self):
        target = self.root / "target file.md"
        target.write_text("# An `Example`!\n\n## Repeated\n\n## Repeated\n", encoding="utf-8")
        page = self.root / "index.md"
        page.write_text("[Heading](target%20file.md#an-example)\n[Duplicate](target%20file.md#repeated-1)", encoding="utf-8")
        self.assertEqual((2, []), checker.check_links([page]))

    def test_missing_files_and_headings_are_errors(self):
        page = self.root / "index.md"
        page.write_text("# Real\n[Missing file](absent.md)\n[Missing heading](#absent)\n", encoding="utf-8")
        checked, errors = checker.check_links([page])
        self.assertEqual(2, checked)
        self.assertEqual(2, len(errors))
        self.assertIn("missing link target", errors[0])
        self.assertIn("missing heading", errors[1])

    def test_teaching_code_blocks_and_external_urls_are_not_local_links(self):
        page = self.root / "index.md"
        page.write_text("```java\n// [Sample](missing.md)\n```\n~~~text\n[Sample](missing.md)\n~~~\n[Web](https://example.com)\n", encoding="utf-8")
        self.assertEqual((0, []), checker.check_links([page]))


if __name__ == "__main__":
    unittest.main()