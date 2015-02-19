name := "cs372s15p2"

version := "0.1"

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % Test,  // required only for plain JUnit testing
  "org.scalatest" %% "scalatest" % "2.2.2" % Test,
  "org.scalacheck" %% "scalacheck" % "1.11.5" % Test
)

// enable scoverage
instrumentSettings
