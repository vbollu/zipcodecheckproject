pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-8'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    
    stages {
        
        stage("build") {
            steps {
                echo 'predicting the future...'
                sh 'mvn clean install'
            }
            post {
                 always {
                      junit '**/target/surefire-reports/TEST-*.xml'
                      jiraSendBuildInfo site: 'vbollu-jenkins-test.atlassian.net', branch:'JIT-6-Test-branch'
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
