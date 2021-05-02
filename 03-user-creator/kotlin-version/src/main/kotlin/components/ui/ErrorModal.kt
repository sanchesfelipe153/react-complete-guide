package components.ui

import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import commons.utils.css
import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.RProps
import react.dom.h2
import react.dom.p
import styled.*

interface ErrorModalProps : RProps {

	var title: String
	var message: String
	var onConfirm: EventHandler

}

val ErrorModal by FunctionalComponentDelegate<ErrorModalProps> { props ->
	styledDiv {
		css { +ErrorModalStyles.backdrop }
		attrs.onClickFunction = props.onConfirm
	}
	Card {
		css { +ErrorModalStyles.modal }
		styledHeader {
			css { +ErrorModalStyles.header }
			h2 { +props.title }
		}
		styledDiv {
			css { +ErrorModalStyles.content }
			p { +props.message }
		}
		styledFooter {
			css { +ErrorModalStyles.actions }
			Button {
				attrs.onClick = props.onConfirm
				+"Okay"
			}
		}
	}
}

private object ErrorModalStyles : StyleSheet("ErrorModalStyles") {

	val backdrop by css {
		position = Position.fixed
		top = 0.px
		left = 0.px
		width = 100.pct
		height = 100.vh
		zIndex = 10
		backgroundColor = rgba(0, 0, 0, 0.75)
	}

	val modal by css {
		position = Position.fixed
		top = 30.vh
		left = 10.pct
		width = 80.pct
		zIndex = 100
		overflow = Overflow.hidden

		media("(min-width: 768px)") {
			put("left", "calc(50% - 20rem)")
			width = 40.rem
		}
	}

	val header by css {
		background = "#4f005f"
		padding(1.rem)

		h2 {
			margin(0.px)
			color = Color.white
		}
	}

	val content by css {
		padding(1.rem)
	}

	val actions by css {
		padding(1.rem)
		display = Display.flex
		justifyContent = JustifyContent.flexEnd
	}

}
