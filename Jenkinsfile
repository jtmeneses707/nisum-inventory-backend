pipeline {
    agent { dockerfile true }
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-creds')
    }
    stages {
        stage('Docker Build Image and Push') {
            steps {
                //Using DockerHub as Container Image repo. Log in, build image, and then push it to DockerHub using credentials.
                sh """
                docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin
                docker build -t $DOCKERHUB_CREDENTIALS_USR/nisum-inventory-backend-app:${env.BUILD_NUMBER} .
                docker push $DOCKERHUB_CREDENTIALS_USR/nisum-inventory-backend-app:${env.BUILD_NUMBER}
                """
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
