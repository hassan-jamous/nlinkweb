pipeline {
    agent any

    stages {

            stage('Checkout') {
                steps {
                    checkout scm
                    gradle tasks: 'wrapper'
                }
            }
        stage('Build') {
            steps {
                 sh './gradlew build'
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