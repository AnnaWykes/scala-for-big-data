name := "scala-blog-deploy"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq( "com.microsoft.azure.functions" % "azure-functions-java-library" % "1.0.0-beta-5", 
"org.scala-lang.modules" %% "scala-xml" % "1.2.0",
"org.scalatest" %% "scalatest" % "3.0.8")

assemblyOutputPath in assembly := baseDirectory.value / "scala-function-app" / "ScalaFunction" / "ScalaFunction.jar"


