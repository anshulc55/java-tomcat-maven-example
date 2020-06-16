import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

class buildMaven(name: String) {
    var commandname: String = name
    //println(commandname)
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
        var robot1=buildMaven("Soumya")
        println(robot1.commandname)
    //buildMaven("clean test")
  /*      maven {
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }*/
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

//val soumya = buildMaven("clean test")

