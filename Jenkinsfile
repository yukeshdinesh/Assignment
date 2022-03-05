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

        stage('Log file') {
        environment {
                  local = 'C:'
                 }
          steps {
            writeFile(file: 'logfile.txt', text: "This is the log file that contains env value ${ChromeDriver} Local env in other stage: ${local}")
          }
        }

      }
    }

    stage('Deployment') {
      parallel {
        stage('Deployment') {
          steps {
            input(message: 'Do you want to deploy', id: 'ok')
            echo 'Deploying the code'
          }
        }

        stage('Archive') {
          steps {
            archiveArtifacts 'logfile.txt'
          }
        }

      }
    }

  }
  environment {
    ChromeDriver = 'C:'
  }
}