name := "start kit"

version := "1.0"

scalaVersion := "2.11.7"


val slickVersion = "3.2.3"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
  "org.mariadb.jdbc" % "mariadb-java-client" % "1.5.9",
  "com.typesafe" % "config" % "1.3.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4" // log library
)