pipeline {
    agent any

    stages {

            stage('Checkout') {
                steps {
                    env
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
