properties([[$class: 'HudsonNotificationProperty',
  endpoints: [[urlInfo: [urlOrId: 'https://4672e004-ff75-4851-b73f-37e35ccce067.hello.atlassian-dev.net/x0/eyJjdHgiOiJhcmk6Y2xvdWQ6amlyYTo6c2l0ZS8xMWUwY2QzYy00ZjIwLTRhYjEtYjhhMS1mM2I0ZWMyZTc0ODgiLCJleHQiOiJhcmk6Y2xvdWQ6ZWNvc3lzdGVtOjpleHRlbnNpb24vNDY3MmUwMDQtZmY3NS00ODUxLWI3M2YtMzdlMzVjY2NlMDY3L2FjNWQ0NjA4LTAwYjYtNDkwZC04YjFiLTJlMGNjNWU1ZWVlMS9zdGF0aWMvd2ViaG9vay1yZWNlaXZlciJ9', urlType: 'PUBLIC']]]]]
 )

pipeline {
  agent any
  tools {
        maven 'maven'
       
    }
     
    stages {
        stage("build") {
            steps {
                sh 'mvn clean install'
            }
            post {
                always {                   
                     jiraSendBuildInfo site: 'nsurendran1991.atlassian.net'
                    
                 }
             }
        }
       
        stage("deploy") {
            steps {
                echo 'deploying...'
            }
            post {
                always {
                    jiraSendDeploymentInfo site: 'nsurendran1991.atlassian.net', enableGating: false, environmentId: 'jenkins-testing-prod-1', environmentName: 'staging', environmentType: 'staging'
                }
            }
        }
    }
}
