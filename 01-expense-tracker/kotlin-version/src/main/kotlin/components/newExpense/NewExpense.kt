package components.newExpense

import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import external.uuid.uuidV4
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.css.properties.boxShadow
import kotlinx.html.js.onClickFunction
import model.Expense
import react.RProps
import react.dom.button
import react.useState
import styled.StyleSheet
import styled.css
import styled.styledDiv

interface NewExpenseProps : RProps {

	var onAddExpense: (Expense) -> Unit

}

val newExpense by FunctionalComponentDelegate<NewExpenseProps> newExpense@{ props ->
	var showForm by useState(false)

	if (!showForm) {
		val addNewExpenseHandler: EventHandler = {
			showForm = true
		}
		styledDiv {
			css { +NewExpenseStyles.container }

			button {
				attrs.onClickFunction = addNewExpenseHandler

				+"Add New Expense"
			}
		}
		return@newExpense
	}

	val saveExpenseDataHandler = { enteredExpenseData: ExpenseData ->
		val expense = Expense(uuidV4(), enteredExpenseData.title, enteredExpenseData.amount, enteredExpenseData.date)
		console.log(expense.id)
		props.onAddExpense(expense)
		showForm = false
	}
	val cancelHandler: EventHandler = {
		showForm = false
	}

	styledDiv {
		css { +NewExpenseStyles.container }

		expenseForm {
			attrs.onSaveExpenseData = saveExpenseDataHandler
			attrs.onCancel = cancelHandler
		}
	}
}

private object NewExpenseStyles : StyleSheet("NewExpenseStyles") {

	val container by css {
		backgroundColor = Color("#a892ee")
		padding(1.rem)
		margin(2.rem, LinearDimension.auto)
		width = 50.rem
		maxWidth = 95.pct
		borderRadius = 12.px
		textAlign = TextAlign.center
		boxShadow(offsetX = 0.px, offsetY = 1.px, blurRadius = 8.px, color = rgba(0, 0, 0, 0.25))

		button {
			put("font", "inherit")
			cursor = Cursor.pointer
			padding(1.rem, 2.rem)
			border(1.px, BorderStyle.solid, Color("#40005d"))
			backgroundColor = Color("#40005d")
			color = Color.white
			borderRadius = 12.px
			marginRight = 1.rem

			val hoverActive by css {
				backgroundColor = Color("#510674")
				borderColor = Color("#510674")
			}
			hover { +hoverActive }
			active { +hoverActive }
		}
	}

}
