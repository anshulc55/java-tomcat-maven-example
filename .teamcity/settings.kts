
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import patches.projects.*

version = "2019.2"

project {
    description = "Java Tomcat Maven Example DSL"
    buildType(Build)
    buildType(Test1)
    //val hello = helloBoss()
}


