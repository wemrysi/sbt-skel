name := "NAME"

organization := "ORG"

version := "0.0.1"

scalaVersion := "2.11.2"

// Resolvers
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
  "bintray/non" at "http://dl.bintray.com/non/maven"
)

// Compile options
// http://tpolecat.github.io/2014/04/11/scalac-flags.html
scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Yno-imports"
)

// Compile Dependencies
libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.1.0"
)

// Wartremover
wartremoverErrors ++= Warts.all

// Kind Projector
addCompilerPlugin("org.spire-math" % "kind-projector_2.11" % "0.5.2")
