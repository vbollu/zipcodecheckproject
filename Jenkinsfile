pipeline {
  agent any
  stages {
    stage('Checkout Scm') {
      steps {
        git 'https://github.com/nsurendran1991/demo.git'
      }
    }

  }
  post {
      always {
                jiraSendBuildInfo site: 'nsurendran1991.atlassian.net'
             }
  }
  triggers {
    pollSCM('* * * * *')
  }
}
