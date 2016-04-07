import org.sonatype.maven.polyglot.scala.model._
import scala.collection.immutable.Seq

Model(
  "" % "com.typesafe.hocon.sdk",
  packaging = "eclipse-feature",
  name = "Typesafe Config Feature",
  parent = Parent(
    gav = "com.typesafe.hocon" % "parent" % "1.0.2-SNAPSHOT",
    relativePath = "../com.typesafe.hocon.releng/pom.xml"
  ),
  modelVersion = "4.0.0"
)
