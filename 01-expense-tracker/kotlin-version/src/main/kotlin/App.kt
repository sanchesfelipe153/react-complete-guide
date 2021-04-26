import commons.utils.FunctionalComponentDelegate
import components.expenses.expenses
import components.newExpense.newExpense
import model.Expense
import react.RProps
import react.dom.div
import react.rawUseState
import kotlin.js.Date

val app by FunctionalComponentDelegate<RProps> {
	val (items, setItems) = rawUseState(dummyExpenses)

	val addExpenseHandler = { expense: Expense ->
		setItems { oldValue: List<Expense> ->
			val newValue = ArrayList(oldValue)
			newValue.add(0, expense)
			newValue
		}
	}

	div {
		newExpense {
			attrs.onAddExpense = addExpenseHandler
		}

		expenses {
			attrs.items = items as List<Expense>
		}
	}
}

private val dummyExpenses = listOf(
	Expense("e1", "Toilet Paper", 94.12, Date(2020, 7, 14)),
	Expense("e2", "New TV", 799.49, Date(2021, 2, 12)),
	Expense("e3", "Car Insurance", 294.67, Date(2021, 2, 28)),
	Expense("e4", "New Desk (Wooden)", 450, Date(2021, 5, 12)),
)
