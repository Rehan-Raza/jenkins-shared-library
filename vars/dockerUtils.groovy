package org.example

class DockerUtils {

    def buildImage(script) {
    def imageTag = "rehan1114/myimg:${script.env.BUILD_NUMBER}"
    script.sh "docker build -t ${imageTag} ."
}
    static void loginDocker(script) {
        script.withCredentials([script.usernamePassword(credentialsId: 'rehan1114-dockerhub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            script.sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
        }
    }

    static void pushImage(script) {
        script.sh "docker push rehan1114/myimg"
    }

    static void runContainer(script) {
        script.sh "docker run -dit --name contt3v rehan1114/myimg"
    }
}
