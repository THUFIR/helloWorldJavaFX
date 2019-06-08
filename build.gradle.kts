/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * user guide available at https://docs.gradle.org/5.0/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

//org.openjfx.javafxplugin

 // org.openjfx.javafxplugin

    // Apply the application plugin to add support for building an application
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependency is found on compile classpath of this component and consumers.
   // implementation("com.google.guava:guava:26.0-jre")

    compile (group = "org.openjfx"                   , name = "javafx"                , version = "11.0.1")
    compile (group = "org.openjfx"                   , name = "javafx-base"           , version = "11.0.1")
    compile (group = "org.openjfx"                   , name = "javafx-controls"       , version = "11.0.1")
    compile (group = "com.google.api-client"         , name = "google-api-client"     , version = "1.29.2")
    compile (group = "com.google.maps"               , name = "google-maps-services"  , version = "0.9.3")
    compile (group = "org.slf4j"                     , name = "slf4j-api"             , version = "1.7.21")
    compile (group = "org.slf4j"                     , name = "slf4j-nop"             , version = "1.8.0-beta4")


   // implementation 'com.google.maps:google-maps-services:(insert latest version)'
   // implementation 'org.slf4j:slf4j-simple:1.7.25'


    // Use TestNG framework, also requires calling test.useTestNG() below
   // testImplementation("org.testng:testng:6.14.3")
}

application {
    // Define the main class for the application
    mainClassName = "net.bounceme.dur.fx.App"
}

val test by tasks.getting(Test::class) {
    // Use TestNG for unit tests
    useTestNG()
}
