package components.ui

import commons.utils.FunctionalComponentDelegate
import commons.utils.RPropsWithCSS
import kotlinx.css.borderRadius
import kotlinx.css.properties.boxShadow
import kotlinx.css.px
import kotlinx.css.rgba
import styled.css
import styled.styledDiv

val card by FunctionalComponentDelegate<RPropsWithCSS> { props ->
	styledDiv {
		css {
			borderRadius = 12.px
			boxShadow(offsetX = 0.px, offsetY = 1.px, blurRadius = 8.px, color = rgba(0, 0, 0, 0.25))

			props.ruleSet?.invoke(this)
		}

		props.children()
	}
}
