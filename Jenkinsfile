pipeline {
  agent any
  stages {
    stage('Git') {
      parallel {
        stage('Git') {
          steps {
            git(url: 'https://github.com/yukeshdinesh/Assignment.git', branch: 'master', changelog: true, poll: true)
          }
        }

        stage('Build') {
          steps {
            sh 'mvn clean'
          }
        }

        stage('Test') {
          steps {
            sh 'mvn test'
          }
        }

      }
    }

    stage('End') {
      steps {
        echo 'Execution completed'
      }
    }

  }
}