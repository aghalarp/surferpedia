name := "surferpedia"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.seleniumhq.selenium" % "selenium-java" % "2.38.0" % "test",
  "mysql" % "mysql-connector-java" % "5.1.21"
)     

play.Project.playJavaSettings
