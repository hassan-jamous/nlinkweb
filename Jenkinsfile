pipeline {
    agent any

    stages {

            stage('Checkout') {
                steps {
                    checkout scm

                }
            }
        stage('Build') {
            steps {
                 sh 'gradle build --info'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
