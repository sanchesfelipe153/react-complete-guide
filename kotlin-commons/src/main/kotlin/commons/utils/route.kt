package commons.utils

import react.RBuilder
import react.RClass
import react.RProps
import react.ReactElement
import react.router.dom.RouteComponent
import react.router.dom.RouteProps
import react.router.dom.RouteResultProps

fun RBuilder.route(
	path: String,
	component: RClass<RProps>,
	exact: Boolean = false,
	strict: Boolean = false
): ReactElement {
	return child<RouteProps<RProps>, RouteComponent<RProps>> {
		attrs {
			this.path = path
			this.exact = exact
			this.strict = strict
			this.component = component
		}
	}
}

fun RBuilder.route(
	path: String,
	exact: Boolean = false,
	strict: Boolean = false,
	render: (props: RouteResultProps<RProps>) -> ReactElement?
): ReactElement {
	return child<RouteProps<RProps>, RouteComponent<RProps>> {
		attrs {
			this.path = path
			this.exact = exact
			this.strict = strict
			this.render = render
		}
	}
}
