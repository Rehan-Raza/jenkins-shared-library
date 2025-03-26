package org.example

class TestUtils {
    static void checkTestResults(script) {
        script.sh """
            errors=\$(grep -oP '(?<=Failures: )\\d+' target/surefire-reports/TEST-summary.txt | awk '{sum += \$1} END {print sum}')
            if [ -z "\$errors" ]; then errors=0; fi
            echo "Total Test Failures: \$errors"
            if [ "\$errors" -ge 6 ]; then
                echo "Build failed: Too many test errors (\$errors)."
                exit 1
            else
                echo "Build continues: Test errors within limit (\$errors)."
            fi
        """
    }
}
