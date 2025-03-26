package org.example

class DockerUtils {
    static void buildImage(script) {
        script.sh "docker build -t rehan1114/myimg ."
    }

    static void loginDocker(script) {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            script.sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
        }
    }

    static void pushImage(script) {
        script.sh "docker push rehan1114/myimg"
    }

    static void runContainer(script) {
        script.sh "docker run -dit --name cont3 rehan1114/myimg"
    }
}
