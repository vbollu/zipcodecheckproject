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
                     junit '**/target/surefire-reports/TEST-*.xml'
                     
                    
                 }
             }
        }
       
        stage("deploy") {
            steps {
                echo 'deploying...'
            }
            
        }
    }



}

