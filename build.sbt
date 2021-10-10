val scala3 = "3.0.2"
lazy val root = project
  .in(file("."))
  .settings(
    name := "parametric-polymorphism",
    description := "Code examples for a Medium blog post on the subject.",
    version := s"$scala3-final",
    scalaVersion := scala3,
    organization := "com.polyglotprogramming",
    organizationName := "Polyglot Programming",
    organizationHomepage := Some(url("http://polyglotprogramming.com")),
    homepage := Some(url("https://github.com/deanwampler/parametric-polymorphism/")),
    licenses += "Apache2" -> url("http://www.apache.org/licenses/LICENSE-2.0"),
    maxErrors := 10,
    libraryDependencies ++= Seq(
      "org.scalacheck"         %% "scalacheck"       % "1.15.4" % Test,
      "org.scalameta"          %% "munit"            % "0.7.26" % Test,
      "org.scalameta"          %% "munit-scalacheck" % "0.7.26" % Test
    ),

    // The following are used in github.com/deanwampler/programming-scala-book-code-examples:
    scalacOptions := Seq(
      "-encoding", "utf-8",                // Specify character encoding used by source files.
      "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
      "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
      "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
      "-explain",                          // Explain errors in more detail.
      "-new-syntax",                       // Require `then` and `do` in control expressions.
      "-source:future",                       // Choices: future and future-migration. I use this to force future deprecation warnings, etc.
      "-Xfatal-warnings",                  // Fail on warnings, not just errors
    ),
    Compile / console / scalacOptions := scalacOptions.value,
    javacOptions ++= Seq(
      "-Xlint:unchecked", "-Xlint:deprecation"), // Java 8: "-Xdiags:verbose"),

    console / initialCommands := "import polyglotprogramming.*",
)
