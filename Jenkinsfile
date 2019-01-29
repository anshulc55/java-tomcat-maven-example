pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {

                /*For Mac & Linux machine */
                sh 'mvn clean package'
            }

            post{
                success{
                    echo 'Now Archiving ....'

                    archiveArtifacts artifacts : '**/*.war'
                }
            }
        }
        
    }
}
