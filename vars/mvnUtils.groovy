// vars/mvnUtils.groovy
def buildProject(String goal) {
    echo "Building project with goal: ${goal}"
    sh "mvn clean install ${goal} "
}

// Expose the method to Jenkins pipeline
return this
