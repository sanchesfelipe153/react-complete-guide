package commons.utils

import kotlinext.js.jsObject
import org.w3c.dom.events.EventTarget
import react.RClass
import react.RProps
import react.ReactElement
import react.buildElement

fun <P : RProps> RClass<P>.rElement(props: P = jsObject()): ReactElement =
	buildElement { child(this@rElement, props) {} }

val EventTarget.value: String?
	get() = this.asDynamic().value as? String
