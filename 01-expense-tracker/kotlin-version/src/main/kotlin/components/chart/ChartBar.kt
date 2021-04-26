package components.chart

import commons.utils.FunctionalComponentDelegate
import kotlinx.css.*
import kotlinx.css.properties.Timing
import kotlinx.css.properties.border
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import react.RProps
import styled.StyleSheet
import styled.css
import styled.styledDiv
import kotlin.math.round

interface ChartBarProps : RProps {

	var label: String
	var value: Number
	var maxValue: Number

}

val chartBar by FunctionalComponentDelegate<ChartBarProps> { props ->
	var barFillHeight: Number = 0
	if (props.maxValue.toDouble() > 0) {
		barFillHeight = round((props.value.toDouble() / props.maxValue.toDouble()) * 100)
	}

	styledDiv {
		css { +ChartBarStyles.container }

		styledDiv {
			css { +ChartBarStyles.inner }

			styledDiv {
				css {
					+ChartBarStyles.fill
					height = barFillHeight.pct
				}
			}
		}

		styledDiv {
			css { +ChartBarStyles.label }

			+props.label
		}
	}
}

private object ChartBarStyles : StyleSheet("ChartBarStyles") {

	val container by css {
		height = 100.pct
		display = Display.flex
		flexDirection = FlexDirection.column
		alignItems = Align.center
	}

	val inner by css {
		height = 100.pct
		width = 100.pct
		border(1.px, BorderStyle.solid, Color("#313131"))
		borderRadius = 12.px
		backgroundColor = Color("#c3b4f3")
		overflow = Overflow.hidden
		display = Display.flex
		flexDirection = FlexDirection.column
		justifyContent = JustifyContent.flexEnd
	}

	val fill by css {
		backgroundColor = Color("#4826b9")
		width = 100.pct
		transition("all", 0.3.s, Timing.easeOut)
	}

	val label by css {
		fontWeight = FontWeight.bold
		fontSize = 0.5.rem
		textAlign = TextAlign.center
	}

}
