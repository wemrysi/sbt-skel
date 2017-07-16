name := "NAME"

organization := "ORG"

version := "0.0.1"

// Resolvers
resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

// Use the Typelevel Scala compiler
scalaOrganization := "org.typelevel"

// Compile options
// http://tpolecat.github.io/2014/04/11/scalac-flags.html
val scalacOptions_2_11 = Seq(
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
  "-Ywarn-unused-import",
  "-Xfuture",
  "-Yno-imports",
  "-Ydelambdafy:method",
  "-Yliteral-types",
  "-Ypartial-unification"
)

val scalacOptions_2_12 = Seq(
  "-Xstrict-patmat-analysis",
  "-Yinduction-heuristics",
  "-Ykind-polymorphism"
)

scalacOptions := (CrossVersion.partialVersion(scalaVersion.value) match {
  case Some((2, 12)) => scalacOptions_2_11 ++ scalacOptions_2_12
  case _             => scalacOptions_2_11
})

scalacOptions in (Test, console) --= Seq(
  "-Yno-imports",
  "-Ywarn-unused-import"
)

scalacOptions in (Compile, doc) -= "-Xfatal-warnings"

// Compile Dependencies
libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)

// Wartremover
wartremoverWarnings in (Compile, compile) ++= Warts.allBut(
  Wart.Any,                   // - see puffnfresh/wartremover#263
  Wart.ExplicitImplicitTypes, // - see puffnfresh/wartremover#226
  Wart.ImplicitConversion,    // - see mpilquist/simulacrum#35
  Wart.Nothing                // - see puffnfresh/wartremover#263
)

// Kind Projector
addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.4")
