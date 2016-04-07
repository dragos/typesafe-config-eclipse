import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "" % "com.typesafe.hocon",
  packaging = "eclipse-plugin",
  name = "Typesafe Config Core",
  parent = Parent(
    gav = "com.typesafe.hocon" % "parent" % "1.0.2-SNAPSHOT",
    relativePath = "../com.typesafe.hocon.releng/pom.xml"
  ),
  build = Build(
    pluginManagement = PluginManagement(
      plugins = Seq(
        Plugin(
          "org.eclipse.m2e" % "lifecycle-mapping" % "1.0.0",
          configuration = Config(
            lifecycleMappingMetadata = Config(
              pluginExecutions = Config(
                pluginExecution = Config(
                  pluginExecutionFilter = Config(
                    groupId = "org.codehaus.mojo",
                    artifactId = "exec-maven-plugin",
                    versionRange = "[1.2.1,)",
                    goals = Config(
                      goal = "java"
                    )
                  ),
                  action = Config(
                    ignore = ""
                  )
                )
              )
            )
          )
        )
      )
    ),
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-clean-plugin",
        executions = Seq(
          Execution(
            id = "gen-clean",
            phase = "clean",
            configuration = Config(
              filesets = Config(
                `@combine.children` = "append",
                fileset = Config(
                  directory = "${basedir}/src-gen/"
                ),
                fileset = Config(
                  directory = "${basedir}/model/generated/"
                ),
                fileset = Config(
                  directory = "${basedir}/../${project.artifactId}.ui/src-gen/"
                ),
                fileset = Config(
                  directory = "${basedir}/../${project.artifactId}.tests/src-gen/"
                )
              )
            )
          )
        )
      ),
      Plugin(
        "org.codehaus.mojo" % "exec-maven-plugin" % "1.2.1",
        executions = Seq(
          Execution(
            phase = "generate-sources",
            goals = Seq(
              "java"
            )
          )
        ),
        dependencies = Seq(
          "org.eclipse.xtext" % "org.eclipse.xtext.xtext" % "${xtext.version}",
          "org.eclipse.xtext" % "org.eclipse.xtext.xbase" % "${xtext.version}",
          "org.eclipse.equinox" % "common" % "3.6.200-v20130402-1505"
        ),
        configuration = Config(
          includeProjectDependencies = "false",
          includePluginDependencies = "true",
          mainClass = "org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher",
          arguments = Config(
            argument = "file://${project.basedir}/src/com/typesafe/config/GenerateHocon.mwe2",
            argument = "-p",
            argument = "runtimeProject=/${project.basedir}"
          )
        )
      ),
      Plugin(
        "org.eclipse.xtend" % "xtend-maven-plugin"
      )
    )
  ),
  modelVersion = "4.0.0"
)
