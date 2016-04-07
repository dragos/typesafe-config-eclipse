import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "" % "com.typesafe.hocon.ui",
  packaging = "eclipse-plugin",
  name = "Typesafe Config UI",
  parent = Parent(
    gav = "com.typesafe.hocon" % "parent" % "1.0.2-SNAPSHOT",
    relativePath = "../com.typesafe.hocon.releng/pom.xml"
  ),
  build = Build(
    plugins = Seq(
      Plugin(
        "org.apache.maven.plugins" % "maven-clean-plugin",
        executions = Seq(
          Execution(
            id = "gen-clean",
            phase = "clean"
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
