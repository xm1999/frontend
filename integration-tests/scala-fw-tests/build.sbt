name := "Fronts Scala fw integration tests"

version := "0.1.0-SNAPSHOT"

resolvers ++= Seq(
  "Sonatype OSS Staging" at "https://oss.sonatype.org/content/repositories/staging"
)

libraryDependencies ++= Seq(
  "com.gu" %% "scala-automation" % "1.27"
)

val ciTest = taskKey[Unit]("Run tests for CI which will return exit code 0 even if a test fails and only run tests tagged with ReadyForProd") 

ciTest := { 
  val testResult = (testOnly in Test).toTask(" -- -n ReadyForProd").result.value
} 