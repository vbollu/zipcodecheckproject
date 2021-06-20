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
      echo 'No converter for Publisher: com.atlassian.jira.cloud.jenkins.buildinfo.freestyle.FreeStylePostBuildStep'
    }

  }
  triggers {
    pollSCM('* * * * *')
  }
}
