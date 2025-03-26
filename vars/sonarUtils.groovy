package org.example

class SonarUtils {
    static void analyzeProject(script) {
        script.withSonarQubeEnv('sonarqube-9') {
            script.sh """
                mvn sonar:sonar \
                  -Dsonar.projectKey=example-java-maven \
                  -Dsonar.sources=src/main/java \
                  -Dsonar.java.binaries=target/classes
            """
        }
    }
}
