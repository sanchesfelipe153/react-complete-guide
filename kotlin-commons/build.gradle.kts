plugins {
	kotlin("js")
	id("org.jetbrains.kotlin.plugin.serialization")
	id("net.saliman.properties")
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

	implementation(Dependencies.kotlin.x.serializationJson)
	implementation(Dependencies.kotlin.x.collectionsImmutable)

	implementation(Dependencies.kotlin.jsWrappers.react)
	implementation(Dependencies.kotlin.jsWrappers.reactDom)
	implementation(Dependencies.kotlin.jsWrappers.reactRouterDom)
	implementation(Dependencies.kotlin.jsWrappers.styled)

	implementation(npm("axios", Versions.axios))
	implementation(npm("react", Versions.react))
	implementation(npm("react-dom", Versions.react))
	implementation(npm("react-router-dom", Versions.reactRouterDom))
	implementation(npm("styled-components", Versions.styled))
	implementation(npm("uuid", Versions.uuid))
}
