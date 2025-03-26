package org.example

class SonarUtils {
    static void analyzeProject(script) {
        script. withSonarQubeEnv('sonarqube-9') {
                script.sh """
                        mvn sonar:sonar \
                          -DargLine="--add-opens java.base/java.lang=ALL-UNNAMED \
                          --add-opens java.base/java.util=ALL-UNNAMED" \
                          -Dsonar.java.binaries=target/sonar
                    """
        }
    }
}
