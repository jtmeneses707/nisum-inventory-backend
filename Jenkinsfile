pipeline {
    agent { dockerfile true }
    stages {
        stage('Prune Image') {
            steps {
                sh 'java -version'
                //sh 'docker image prune -f'
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
