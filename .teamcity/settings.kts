
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

version = "2019.2"

project {
    description = "Java Tomcat Maven Example DSL"
    buildType(Build)
    buildType(Test1)
    buildType(CodeAnalysis)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            coverageEngine = jacoco {
            classLocations = "'+:build/main/**/*.class'"
            excludeClasses = ""
            }
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

object Test1 : BuildType({
    name = "Test1"
    vcs {
        root(DslContext.settingsRoot)
    }
    steps {
        script {
            scriptContent = "echo Test Successful"
        //    scriptcall()
        }
    }
    triggers {
        vcs {
        }
    }
})

object CodeAnalysis : BuildType({
    name = "CodeAnalysis"
    vcs {
        root(DslContext.settingsRoot)
    }
    steps {
        
        maven {
            goals = "sonar:sonar"
        }
        script {
            scriptContent = "echo Test Successful"
        }
    }
    triggers {
        vcs {
        }
    }
})
