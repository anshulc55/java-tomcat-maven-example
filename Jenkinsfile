pipeline {
    agent any
    tools {
        maven 'LocalMaven'
        jdk 'LocalJDK'
    }

    stages {
        stage ('Build Servlet Project') {
            steps {
                /*For Mac & Linux machine */
                //sh '/Applications/apache-maven-3.6.0/bin/mvn -f /Users/Shared/Jenkins/Home/workspace/Code_pipeline_build_deploy/pom.xml clean package'
                withMaven(maven: 'LocalMaven') {
                    sh 'mvn clean package'
                }
                //sh 'mvn -f /Users/Shared/Jenkins/Home/workspace/Code_pipeline_build_deploy/pom.xml clean package'
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
