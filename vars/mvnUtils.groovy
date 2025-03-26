// vars/mvnUtils.groovy
def buildProject(String goal) {
    echo "Building project with goal: ${goal}"
    sh "mvn clean ${goal} -DskipTests"
}

// Expose the method to Jenkins pipeline
return this
