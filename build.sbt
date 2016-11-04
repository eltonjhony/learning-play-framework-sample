import play.Project._

name := "hello-world-play"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  filters
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.6"

play.Project.playJavaSettings
