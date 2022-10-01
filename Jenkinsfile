pipeline {
    agent { dockerfile true }
    stages {
        stage('Docker Build Image and Push') {
            steps {
                script {
                    //Using DockerHub as Container Image repo. Log in, build image, and then push it to DockerHub using credentials.
                    docker.withRegistry('https://hub.docker.com/', 'dockerhub-creds') {
                        app = docker.build(ihuang12/nisum-inventory-backend-app)
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
                echo '========== Continuous Integration ends here =========='
            }
        }
    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}