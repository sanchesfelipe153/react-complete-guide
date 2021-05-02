plugins {
	kotlin("js")
	id("dependencies")
}

kotlin {
	js {
		browser {
			commonWebpackConfig {
				cssSupport.enabled = true
			}
		}
		binaries.executable()
	}
}

dependencies {
	implementation(kotlin("stdlib-js"))
	implementation(project(":kotlin-commons"))

	implementation(Dependencies.kotlin.jsWrappers.react)
	implementation(Dependencies.kotlin.jsWrappers.reactDom)
	implementation(Dependencies.kotlin.jsWrappers.styled)

	implementation(npm("react", Versions.react))
	implementation(npm("react-dom", Versions.react))
	implementation(npm("styled-components", Versions.styled))
	implementation(npm("uuid", Versions.uuid))
}
