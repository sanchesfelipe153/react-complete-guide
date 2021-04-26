package components.expenses

import commons.utils.FunctionalComponentDelegate
import kotlinx.css.*
import model.Expense
import react.RProps
import styled.css
import styled.styledH2
import styled.styledUl

interface ExpensesListProps : RProps {

	var items: List<Expense>

}

val expensesList by FunctionalComponentDelegate<ExpensesListProps> expensesList@{ props ->
	if (props.items.isEmpty()) {
		styledH2 {
			css {
				color = Color.white
				textAlign = TextAlign.center
			}
			+"Found no expenses."
		}
		return@expensesList
	}

	styledUl {
		css {
			listStyleType = ListStyleType.none
			padding(0.px)
		}

		props.items.renderEach {
			expenseItem {
				attrs {
					key = it.id
					title = it.title
					amount = it.amount
					date = it.date
				}
			}
		}
	}
}
