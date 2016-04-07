import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "" % "com.typesafe.hocon.updatesite",
  packaging = "eclipse-repository",
  name = "Typesafe Config Update Site",
  parent = Parent(
    gav = "com.typesafe.hocon" % "parent" % "1.0.2-SNAPSHOT",
    relativePath = "../com.typesafe.hocon.releng/pom.xml"
  ),
  build = Build(
    plugins = Seq(
      Plugin(
        "org.eclipse.tycho" % "tycho-p2-director-plugin" % "${tycho-version}",
        executions = Seq(
          Execution(
            id = "materialize-products",
            goals = Seq(
              "materialize-products"
            )
          ),
          Execution(
            id = "archive-products",
            goals = Seq(
              "archive-products"
            )
          )
        )
      )
    )
  ),
  modelVersion = "4.0.0"
)
