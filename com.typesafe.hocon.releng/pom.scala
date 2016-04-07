import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "com.typesafe.hocon" % "parent" % "1.0.2-SNAPSHOT",
  packaging = "pom",
  modules = Seq(
    "../com.typesafe.hocon",
    "../com.typesafe.hocon.ui",
    "../com.typesafe.hocon.tests",
    "../com.typesafe.hocon.sdk",
    "../com.typesafe.hocon.updatesite"
  ),
  repositories = Seq(
    Repository(
      id = "eclipse",
      url = "http://download.eclipse.org/releases/mars/201506241002/",
      layout = "p2"
    ),
    Repository(
      id = "Xtext Update Site",
      url = "http://download.eclipse.org/modeling/tmf/xtext/updates/releases/${xtext.version}/",
      layout = "p2"
    )
  ),
  properties = Map(
    "xtext.version" -> "2.8.4",
    "tycho-version" -> "0.23.0",
    "project.build.sourceEncoding" -> "UTF-8"
  ),
  build = Build(
    pluginManagement = PluginManagement(
      plugins = Seq(
        Plugin(
          "org.eclipse.xtend" % "xtend-maven-plugin" % "${xtext.version}",
          executions = Seq(
            Execution(
              goals = Seq(
                "compile",
                "xtend-install-debug-info",
                "testCompile",
                "xtend-test-install-debug-info"
              )
            )
          ),
          configuration = Config(
            outputDirectory = "xtend-gen"
          )
        ),
        Plugin(
          "org.apache.maven.plugins" % "maven-clean-plugin" % "2.5",
          executions = Seq(
            Execution(
              id = "gen-clean",
              goals = Seq(
                "clean"
              ),
              configuration = Config(
                filesets = Config(
                  fileset = Config(
                    directory = "${basedir}/xtend-gen"
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
        "org.eclipse.tycho" % "tycho-maven-plugin" % "${tycho-version}",
        extensions = true
      )
    )
  ),
  modelVersion = "4.0.0"
)
