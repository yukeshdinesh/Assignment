pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building Job'
          }
        }

        stage('Test') {
          steps {
            echo 'Testing the code '
            echo "Environmental path ${ChromeDriver}"
          }
        }

      }
    }

    stage('Deployment') {
      steps {
        input(message: 'Do you want to deploy', id: 'ok')
        echo 'Deploying the code'
      }
    }

  }
  environment {
    ChromeDriver = 'C:'
  }
}