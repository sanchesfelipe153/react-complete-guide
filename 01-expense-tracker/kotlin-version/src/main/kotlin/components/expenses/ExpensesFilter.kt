package components.expenses

import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import commons.utils.value
import kotlinx.css.*
import kotlinx.html.js.onChangeFunction
import react.RProps
import react.dom.label
import react.dom.option
import react.dom.select
import styled.StyleSheet
import styled.css
import styled.styledDiv

interface ExpensesFilterProps : RProps {

	var selected: String
	var onChangeFilter: (String) -> Unit

}

val expensesFilter by FunctionalComponentDelegate<ExpensesFilterProps> { props ->
	val changeHandler: EventHandler = { event ->
		props.onChangeFilter(event.target?.value ?: "")
	}

	styledDiv {
		css { +ExpensesFilterStyles.container }
		styledDiv {
			css { +ExpensesFilterStyles.control }

			label {
				+"Filter by year"
			}

			select {
				attrs.onChangeFunction = changeHandler
				attrs.value = props.selected

				option {
					attrs.value = "2022"
					attrs.label = "2022"
				}
				option {
					attrs.value = "2021"
					attrs.label = "2021"
				}
				option {
					attrs.value = "2020"
					attrs.label = "2020"
				}
				option {
					attrs.value = "2019"
					attrs.label = "2019"
				}
			}
		}
	}
}

private object ExpensesFilterStyles : StyleSheet("ExpensesFilterStyles") {

	val container by css {
		color = Color.white
		padding(0.px, 1.rem)

		label {
			fontWeight = FontWeight.bold
			marginBottom = 0.5.rem
		}

		select {
			put("font", "inherit")
			padding(0.5.rem, 3.rem)
			fontWeight = FontWeight.bold
			borderRadius = 6.px
		}
	}

	val control by css {
		display = Display.flex
		width = 100.pct
		alignItems = Align.center
		justifyContent = JustifyContent.spaceBetween
		margin(1.rem, 0.px)
	}

}
