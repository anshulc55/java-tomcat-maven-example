pipeline {
    agent any
    tools {
        maven 'LocalMaven'
    }
 
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
        stage ('Deploy Build in Staging Area'){
                steps{

                    build job : 'Deploy_Servlet_staging_env_pipeline'

                }
            }
        stage ('Deploy to Production'){
            steps{
                timeout (time: 5, unit:'DAYS'){
                    input message: 'Approve PRODUCTION Deployment?'
                }
                    
                    build job : 'Deploy_to_Production_Pipeline'
                }

                post{
                    success{
                        echo 'Deployment on PRODUCTION is Successful'
                    }

                    failure{
                        echo 'Deployement Failure on PRODUCTION'
                    }
                }
            }
        }
    }
}
