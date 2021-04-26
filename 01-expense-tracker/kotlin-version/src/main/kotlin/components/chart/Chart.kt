package components.chart

import commons.utils.FunctionalComponentDelegate
import kotlinx.css.*
import react.RProps
import styled.css
import styled.styledDiv

data class DataPoint(
	val label: String, var value: Number
)

interface ChartProps : RProps {

	var dataPoints: List<DataPoint>

}

val chart by FunctionalComponentDelegate<ChartProps> { props ->
	val totalMax = props.dataPoints.map { it.value.toDouble() }.maxOrNull() ?: 0

	styledDiv {
		css {
			padding(1.rem)
			borderRadius = 12.px
			backgroundColor = Color("#f8dfff")
			textAlign = TextAlign.center
			display = Display.flex
			justifyContent = JustifyContent.spaceAround
			height = 10.rem
		}

		props.dataPoints.renderEach {
			chartBar {
				attrs {
					key = it.label
					label = it.label
					value = it.value
					maxValue = totalMax
				}
			}
		}
	}
}
