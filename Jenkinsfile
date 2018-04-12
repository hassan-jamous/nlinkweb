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
                 sh '''/var/lib/jenkins/tools/hudson.plugins.gradle.GradleInstallation/gradle4.6/bin/gradle build '''
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
