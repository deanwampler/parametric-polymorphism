resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.20")
