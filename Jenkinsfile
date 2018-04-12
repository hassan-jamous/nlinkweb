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
                 gradle('build')
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
