pipeline {
    agent any
    tools {
        maven 'LocalMaven'
        jdk 'LocalJDK'
    }

    stages {
        stage ('Build Servlet Project') {
            steps {
                build job : 'package_servlate_project'
            }
        }
        stage ('Deploy Build in Staging Area') {
            steps {
                build job : 'Deploy_Servlet_staging_env_pipeline'
            }
        }
        stage ('Deploy Build in Production ') {
            steps {
                build job : 'Deploy_to_Production_Pipeline'
            }
        }     
    }
}
