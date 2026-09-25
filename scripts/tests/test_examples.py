from pathlib import Path
import subprocess
import sys
import unittest


ROOT = Path(__file__).resolve().parents[2]


class LearningExampleTests(unittest.TestCase):
    def test_inheritance_checks_runtime_type_through_parent_reference(self):
        result = subprocess.run(
            [sys.executable, str(ROOT / "scripts/java.py"), "run", "Phase3_Inheritance_Polymorphism"],
            cwd=ROOT,
            capture_output=True,
            text=True,
            timeout=40,
        )
        self.assertEqual(0, result.returncode, result.stdout + result.stderr)
        self.assertIn("Is dog2 an Animal? true", result.stdout)
        self.assertIn("Is dog2 a Dog? true", result.stdout)
        self.assertIn("Is dog2 a Cat? false", result.stdout)
        self.assertIn("Rex barks: Woof!", result.stdout)
        self.assertIn("Mittens meows: Meow!", result.stdout)
        self.assertIn("Tweety chirps: Tweet tweet!", result.stdout)


if __name__ == "__main__":
    unittest.main()