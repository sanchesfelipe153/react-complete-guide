plugins {
	`kotlin-dsl`
	`java-gradle-plugin`
}

group = "com.staticsanches.react.complete.guide.dependencies"
version = "0.0.1-SNAPSHOT"

repositories {
	google()
	jcenter()
	mavenCentral()
	maven(url = "https://maven.google.com")
}

gradlePlugin {
	plugins {
		register("dependencies") {
			id = "dependencies"
			implementationClass = "com.staticsanches.react.complete.guide.dependencies.DependenciesPlugin"
		}
		register("check-plugins-versions") {
			id = "check-plugins-versions"
			implementationClass = "com.staticsanches.react.complete.guide.dependencies.CheckPluginsVersionsPlugin"
		}
	}
}
