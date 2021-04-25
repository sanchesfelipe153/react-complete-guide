plugins {
	kotlin("js")
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
}
