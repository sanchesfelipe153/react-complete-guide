plugins {
	id("check-plugins-versions")
	idea
}

buildscript {

	repositories {
		google()
		mavenCentral()
		maven(url = "https://maven.google.com")
	}

	val kotlinVersion = "1.4.30"
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-serialization:${kotlinVersion}")
		classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.7.0")
		classpath("net.saliman:gradle-properties-plugin:1.5.1")
	}

}

allprojects {

	group = "com.staticsanches.react.complete.guide"
	version = "0.0.1-SNAPSHOT"

	repositories {
		google()
		mavenCentral()
		maven(url = "https://maven.google.com")
		maven(url = "https://dl.bintray.com/kotlin/kotlin-dev")
		maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
		maven(url = "https://dl.bintray.com/kotlin/kotlin-js-wrappers")
		maven(url = "https://dl.bintray.com/kotlin/kotlinx")
		maven(url = "https://kotlin.bintray.com/kotlinx/")
	}

}

idea {
	module {
		name = "react-complete-guide"
		excludeDirs = excludeDirs + file(".idea") + file("gradle") + file("01-expense-tracker/js-version")
	}
}
