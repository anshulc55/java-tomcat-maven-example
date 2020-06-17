import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs


version = "2019.2"

project {
    sequence {
    description = "Java Tomcat Maven Example DSL"
    buildType(Build)
    buildType(Test)
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        script {
            scriptContent = "echo Build Successful from soumya"
        }
        //buildstep1("Soumya Prakash Barik")
    }

    triggers {
        vcs {
        }
    }
})

object Test : BuildType({
    name = "Test"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "Test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
        script {
            scriptContent = "echo Test Successful"
        }
        //buildstep1("Soumya Prakash Barik")
    }

    triggers {
        vcs {
        }
    }
})
