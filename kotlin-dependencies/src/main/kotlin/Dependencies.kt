@file:Suppress("UNUSED")

/**
 * Centralize all used dependencies.
 */
object Dependencies {

	val kotlin = Kotlin

	object Kotlin {

		val jsWrappers = JsWrappers
		val x = X

		object JsWrappers : DependencyGroup("org.jetbrains", "kotlin") {

			val react by dependency(Versions.kotlinReact)
			val reactDom by dependency(Versions.kotlinReact)
			val reactRouterDom by dependency(Versions.kotlinReactRouterDom)
			val redux by dependency(Versions.kotlinRedux)
			val reactRedux by dependency(Versions.kotlinReactRedux)
			val styled by dependency(Versions.kotlinStyled)

		}

		object X : DependencyGroup("org.jetbrains.kotlinx", "kotlinx") {

			val atomicfu by dependency(Versions.kotlinxAtomicfu)
			val collectionsImmutable by dependency(Versions.kotlinxCollectionsImmutable)
			val coroutines = Coroutines
			val datetime by dependency(Versions.kotlinxDatetime)
			val html = Html
			val serializationJson by dependency(Versions.kotlinxSerializationJson)

			object Coroutines :
				DependencyGroupWithVersion(X, "coroutines", Versions.kotlinxCoroutines) {

				val android by dependency()
				val core by dependency()
				val coreJs by dependency()

			}

			object Html : DependencyGroupWithVersion(X, "html", Versions.kotlinxHtml) {

				val js by dependency()
				val jvm by dependency()

			}

		}

	}

}
