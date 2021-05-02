package components.ui

import commons.utils.FunctionalComponentDelegate
import commons.utils.RPropsWithCSS
import kotlinx.css.background
import kotlinx.css.borderRadius
import kotlinx.css.properties.boxShadow
import kotlinx.css.px
import kotlinx.css.rgba
import styled.css
import styled.styledDiv

val Card by FunctionalComponentDelegate<RPropsWithCSS> { props ->
	styledDiv {
		css {
			background = "white"
			boxShadow(offsetX = 0.px, offsetY = 2.px, blurRadius = 8.px, color = rgba(0, 0, 0, 0.26))
			borderRadius = 10.px

			props.ruleSet?.invoke(this)
		}

		props.children()
	}
}
