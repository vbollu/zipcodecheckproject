pipeline {
    agent any
    
    stages {
        stage("build") {
            steps {
                echo 'predicting the future...'
            }
            post {
                 always {
                     jiraSendBuildInfo site: 'vbollu-jenkins-test.atlassian.net', branch:'JIT-5-Test-branch'
                 }
             }
        }
        
        stage("deploy") {
            steps {
                echo 'deploying...'
            }
            post {
                always {
                    jiraSendDeploymentInfo site: 'vbollu-jenkins-test.atlassian.net', enableGating: false, environmentId: 'jenkins-testing-prod-1', environmentName: 'jenkins-testing-prod-1', environmentType: 'prod'
                }
            }
        }
    }
}
