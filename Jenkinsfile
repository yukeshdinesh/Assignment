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
            echo '"Environmental path $(ChromeDriver)"'
          }
        }

      }
    }

    stage('Deployment') {
      steps {
        echo 'Deploying the code'
      }
    }

  }
  environment {
    ChromeDriver = 'C:'
  }
}