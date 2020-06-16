import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

public final class BuildSteps {

fun BuildSteps.buildstep1(name: String) {
    step {
        param("name", name) // your parameter here
        println(name)
    }
}
}

version = "2019.2"

project {
    description = "Java Tomcat Maven Example DSL"
    buildType(Build)
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
        }
        script {
            scriptContent = "echo Build Successful from soumya"
        }
        buildstep1("Soumya Prakash Barik")
    }

    triggers {
        vcs {
        }
    }
})
