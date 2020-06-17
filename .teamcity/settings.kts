//settings.kts

import jetbrains.buildServer.configs.kotlin.v2018_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.project
import jetbrains.buildServer.configs.kotlin.v2018_2.version

version = "2018.2"


project {
    sequence {
        build(Compile) {
            produces("application.jar")
        }
        build(Test) {
            requires(Compile, "application.jar")
            produces("test.reports.zip")
        }
        build(Package) {
            requires(Compile, "application.jar")
            produces("application.zip")
        }
    }
}

object Compile : BuildType({
    name = "Compile"
    //...
})

object Test : BuildType({
    name = "Test"
    //...
})

object Package : BuildType({
    name = "Package"
    //...
})
