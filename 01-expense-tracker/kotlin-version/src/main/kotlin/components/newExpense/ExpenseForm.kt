package components.newExpense

import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import commons.utils.value
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import react.RProps
import react.dom.button
import react.dom.form
import react.dom.input
import react.dom.label
import react.useState
import styled.StyleSheet
import styled.css
import styled.styledDiv
import kotlin.js.Date
import kotlin.js.RegExp

interface ExpenseFormProps : RProps {

	var onSaveExpenseData: (ExpenseData) -> Unit
	var onCancel: EventHandler

}

val expenseForm by FunctionalComponentDelegate<ExpenseFormProps> { props ->
	var enteredTitle by useState("")
	var enteredAmount by useState("")
	var enteredDate by useState("")

	val titleChangeHandler: EventHandler = { event ->
		enteredTitle = event.target?.value ?: ""
	}
	val amountChangeHandler: EventHandler = { event ->
		enteredAmount = event.target?.value ?: ""
	}
	val dateChangeHandler: EventHandler = { event ->
		enteredDate = event.target?.value ?: ""
	}
	val submitHandler: EventHandler = { event ->
		event.preventDefault()

		var date = Date(enteredDate)
		val dateMatch = RegExp("(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)").exec(enteredDate)?.asArray()
		if (dateMatch != null) {
			// Workaround for different timezones
			date = Date(dateMatch[1]!!.toInt(), dateMatch[2]!!.toInt() - 1, dateMatch[3]!!.toInt())
		}

		val expenseData = ExpenseData(enteredTitle, enteredAmount.toDouble(), date)
		props.onSaveExpenseData(expenseData)

		enteredTitle = ""
		enteredAmount = ""
		enteredDate = ""
	}

	form {
		attrs.onSubmitFunction = submitHandler

		styledDiv {
			css { +ExpenseFormStyles.controls }

			styledDiv {
				css { +ExpenseFormStyles.control }

				label { +"Title" }
				input {
					attrs {
						type = InputType.text
						value = enteredTitle
						onChangeFunction = titleChangeHandler
					}
				}
			}
			styledDiv {
				css { +ExpenseFormStyles.control }

				label { +"Amount" }
				input {
					attrs {
						type = InputType.number
						min = "0.01"
						step = "0.01"
						value = enteredAmount
						onChangeFunction = amountChangeHandler
					}
				}
			}
			styledDiv {
				css { +ExpenseFormStyles.control }

				label { +"Date" }
				input {
					attrs {
						type = InputType.date
						min = "2019-01-01"
						max = "2022-12-31"
						value = enteredDate
						onChangeFunction = dateChangeHandler
					}
				}
			}
		}
		styledDiv {
			css { +ExpenseFormStyles.actions }

			button {
				attrs.type = ButtonType.button
				attrs.onClickFunction = props.onCancel
				+"Cancel"
			}
			button {
				attrs.type = ButtonType.submit
				+"Add Expense"
			}
		}
	}

}

private object ExpenseFormStyles : StyleSheet("ExpenseFormStyles") {

	val controls by css {
		display = Display.flex
		flexWrap = FlexWrap.wrap
		gap = 1.rem.gap
		marginBottom = 1.rem
		textAlign = TextAlign.left
	}

	val control by css {
		label {
			fontWeight = FontWeight.bold
			marginBottom = 0.5.rem
			display = Display.block
		}

		input {
			put("font", "inherit")
			padding(0.5.rem)
			borderRadius = 6.px
			border(1.px, BorderStyle.solid, Color("#ccc"))
			width = 20.rem
			maxWidth = 100.pct
		}
	}

	val actions by css {
		textAlign = TextAlign.right
	}

}
