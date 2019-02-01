pipeline 
{
    agent any
    tools 
    {
        maven 'LocalMaven'
    }
 
    stages
    {
        stage ('Build Servlet Project')
        {
            steps
            {

                /*For Mac & Linux machine */
                sh 'mvn clean package'
            }

            post
            {
                success
                {
                    echo 'Now Archiving ....'

                    archiveArtifacts artifacts : '**/*.war'
                }
            }
        }
        stage ('Deploy Build in Staging Area')
        {
            steps
            {

                build job : 'Deploy_Servlet_staging_env_pipeline'

            }
        }
        
        
    }
}
