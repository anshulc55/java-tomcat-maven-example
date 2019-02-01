pipeline {
    agent any
    tools {
        maven 'LocalMaven'
    }

    stages {
        stage ('Build Servlet Project') {
            steps{
                /*For Mac & Linux machine */
                //sh '/Applications/apache-maven-3.6.0/bin/mvn -f /Users/Shared/Jenkins/Home/workspace/Code_pipeline_build_deploy/pom.xml clean package'
                sh 'mvn clean package'
            }

            post {
                success {
                    echo 'Now Archiving ....'

                    archiveArtifacts artifacts : '**/*.war'
                }
            }
        }
        stage ('Deploy Build in Staging Area') {
            steps {
                build job : 'Deploy_Servlet_staging_env_pipeline'
            }
        }   
    }
}
