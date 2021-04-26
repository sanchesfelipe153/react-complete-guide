package components.expenses

import commons.utils.FunctionalComponentDelegate
import commons.utils.css
import components.ui.card
import kotlinx.css.*
import model.Expense
import react.RProps
import react.dom.div
import react.useState

interface ExpensesProps : RProps {

	var items: List<Expense>

}

val expenses by FunctionalComponentDelegate<ExpensesProps> { props ->
	var filteredYear by useState("2021")

	val filterChangeHandler = { year: String ->
		filteredYear = year
	}

	val filteredExpenses = props.items
		.filter { expense -> expense.date.getFullYear().toString() == filteredYear }
		.sortedByDescending { it.date.getTime() }

	div {
		card {
			css {
				padding(1.rem)
				backgroundColor = rgb(31, 31, 31)
				margin(2.rem, LinearDimension.auto)
				width = 50.rem
				maxWidth = 95.pct
			}

			expensesFilter {
				attrs.selected = filteredYear
				attrs.onChangeFilter = filterChangeHandler
			}

			expensesChart {
				attrs.expenses = filteredExpenses
			}

			expensesList {
				attrs.items = filteredExpenses
			}
		}
	}
}
