pipeline {

  agent any
  tools {
        maven 'maven'
       
    }
stage('Test back pointer') {
      steps {
        script {
          step([
            $class: 'JiraIssueUpdater',
            issueSelector: [
              $class: 'DefaultIssueSelector'
            ],
            scm: [
              $class: 'GitSCM',
              userRemoteConfigs: [[
                url: 'https://github.com/nsurendran1991/zipcodecheckproject.git'
                ]
              ],
              branches: [
                [ name: 'refs/heads/master', name: 'refs/heads/NJ-9-feature-branch', name: 'refs/heads/NJ-10-freestyle-feature-branch']
              ]
            ]
          ])
        }
      }
}
}
