import sbt._

class ConwaysGameOfLife(info: ProjectInfo) extends DefaultProject(info) {
    val scalaToolsRepository = "Scala-Tools Maven2 Repository" at "http://www.scala-tools.org/repo-releases/"
    val scalatest = "org.scalatest" % "scalatest" % "1.3"
}

// vim: set ts=4 sw=4 et: