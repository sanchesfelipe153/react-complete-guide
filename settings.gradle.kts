rootProject.name = "react-complete-guide"

pluginManagement {
	repositories {
		google()
		jcenter()
		gradlePluginPortal()
	}
}

includeBuild("kotlin-dependencies")

include(":kotlin-commons")

include(":expense-tracker")
project(":expense-tracker").projectDir = file("01-expense-tracker/kotlin-version")

include(":user-creator")
project(":user-creator").projectDir = file("03-user-creator/kotlin-version")
