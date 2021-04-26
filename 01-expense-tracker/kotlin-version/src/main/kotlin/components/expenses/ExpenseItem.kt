package components.expenses

import commons.utils.FunctionalComponentDelegate
import commons.utils.css
import components.ui.card
import kotlinx.css.*
import kotlinx.css.properties.border
import react.RProps
import react.dom.h2
import react.dom.li
import styled.StyleSheet
import styled.css
import styled.styledDiv
import kotlin.js.Date

interface ExpenseItemProps : RProps {

	var title: String
	var amount: Number
	var date: Date

}

val expenseItem by FunctionalComponentDelegate<ExpenseItemProps> { props ->
	li {
		card {
			css { +ExpenseItemStyles.item }

			expenseDate {
				attrs.date = props.date
			}

			styledDiv {
				css { +ExpenseItemStyles.description }
				h2 {
					+props.title
				}
				styledDiv {
					css { +ExpenseItemStyles.price }
					+"\$ ${props.amount}"
				}
			}
		}
	}
}

private object ExpenseItemStyles : StyleSheet("ExpenseItemStyles") {

	val item by css {
		display = Display.flex
		justifyContent = JustifyContent.spaceBetween
		alignItems = Align.center
		padding(0.5.rem)
		margin(1.rem, 0.px)
		backgroundColor = Color("#4b4b4b")

		h2 {
			fontSize = 1.rem
			flex(1.0)
			margin(0.px, 1.rem)
			color = Color.white
		}
	}

	val description by css {
		display = Display.flex
		flexDirection = FlexDirection.column
		gap = 1.rem.gap
		alignItems = Align.flexEnd
		put("flex-flow", "column-reverse")
		justifyContent = JustifyContent.flexStart
		flex(1.0)

		media("(min-width: 580px)") {
			flexDirection = FlexDirection.row
			alignItems = Align.center
			justifyContent = JustifyContent.flexStart
			flex(1.0)

			h2 {
				fontSize = 1.25.rem
			}
		}
	}

	val price by css {
		fontSize = 1.rem
		fontWeight = FontWeight.bold
		color = Color.white
		backgroundColor = Color("#40005d")
		border(1.px, BorderStyle.solid, Color.white)
		padding(0.5.rem)
		borderRadius = 12.px

		media("(min-width: 580px)") {
			fontSize = 1.25.rem
			padding(0.5.rem, 1.5.rem)
		}
	}

}
