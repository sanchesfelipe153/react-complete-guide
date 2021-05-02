package components.ui

import commons.hoc.defaultProps
import commons.hoc.wrappedBy
import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.ButtonType
import kotlinx.html.js.onClickFunction
import react.RProps
import styled.css
import styled.styledButton

interface ButtonProps : RProps {

	var type: ButtonType
	var onClick: EventHandler

}

val Button by FunctionalComponentDelegate<ButtonProps> { props ->
	styledButton {
		css {
			put("font", "inherit")
			border(1.px, BorderStyle.solid, Color("#4f005f"))
			background = "#4f005f"
			color = Color.white
			padding(0.25.rem, 1.rem)
			cursor = Cursor.pointer

			hover {
				background = "#741188"
				borderColor = Color("#741188")
			}
			active {
				background = "#741188"
				borderColor = Color("#741188")
			}
			focus {
				outline = Outline.none
			}
		}
		attrs.type = props.type
		attrs.onClickFunction = props.onClick

		props.children()
	}
} wrappedBy defaultProps { type = ButtonType.button }
