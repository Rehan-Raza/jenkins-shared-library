// vars/mvnUtils.groovy
def buildProject() {
    sh 'mvn clean install -DskipTests'
}
