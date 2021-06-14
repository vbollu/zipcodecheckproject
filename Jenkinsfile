pipeline {
  agent any
  stages {
    stage('Checkout Scm') {
      steps {
        git 'https://github.com/nsurendran1991/demo.git'
      }
    }

    stage('Maven Build 0') {
      steps {
        sh 'mvn clean install'
      }
    }

  }
  tools {
    maven 'maven'
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
