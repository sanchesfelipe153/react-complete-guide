package components.expenses

import commons.utils.FunctionalComponentDelegate
import kotlinx.css.*
import kotlinx.css.properties.border
import react.RProps
import styled.StyleSheet
import styled.css
import styled.styledDiv
import kotlin.js.Date

interface ExpenseDateProps : RProps {

	var date: Date

}

val expenseDate by FunctionalComponentDelegate<ExpenseDateProps> { props ->
	val month = props.date.toLocaleString("en-US", dateLocaleOptions { month = "long" })
	val day = props.date.toLocaleString("en-US", dateLocaleOptions { day = "2-digit" })
	val year = props.date.getFullYear()

	styledDiv {
		css { +ExpenseDateStyles.date }

		styledDiv {
			css { +ExpenseDateStyles.month }
			+month
		}

		styledDiv {
			css { +ExpenseDateStyles.year }
			+year.toString()
		}

		styledDiv {
			css { +ExpenseDateStyles.day }
			+day
		}
	}
}

private object ExpenseDateStyles : StyleSheet("ExpenseDateStyles") {

	val date by css {
		display = Display.flex
		flexDirection = FlexDirection.column
		width = 5.5.rem
		height = 5.5.rem
		border(1.px, BorderStyle.solid, Color("#ececec"))
		backgroundColor = Color("#2a2a2a")
		color = Color.white
		borderRadius = 12.px
		alignItems = Align.center
		justifyContent = JustifyContent.center
	}

	val month by css {
		fontSize = 0.75.rem
		fontWeight = FontWeight.bold
	}

	val year by css {
		fontSize = 0.75.rem
	}

	val day by css {
		fontSize = 1.5.rem
		fontWeight = FontWeight.bold
	}

}
