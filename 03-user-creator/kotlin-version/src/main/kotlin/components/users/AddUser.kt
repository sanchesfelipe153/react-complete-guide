package components.users

import commons.utils.EventHandler
import commons.utils.FunctionalComponentDelegate
import commons.utils.css
import commons.utils.value
import components.ui.Button
import components.ui.Card
import components.ui.ErrorModal
import kotlinx.css.*
import kotlinx.css.properties.border
import kotlinx.html.ButtonType
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onSubmitFunction
import react.RProps
import react.dom.form
import react.dom.input
import react.dom.label
import react.useState
import styled.StyleSheet

interface AddUserProps : RProps {

	var onAddUser: (name: String, age: Int) -> Unit

}

val AddUser by FunctionalComponentDelegate<AddUserProps> { props ->
	val (userName, setUserName) = useState("")
	val (age, setAge) = useState("")
	val (error, setError) = useState<ErrorInfo?>(null)

	val addUserHandler: EventHandler = addUserHandler@{ event ->
		event.preventDefault()

		if (userName.trim().isEmpty() || age.trim().isEmpty()) {
			setError(
				ErrorInfo(
					"Invalid input",
					"Please enter a valid name and age (non-empty values)."
				)
			)
			return@addUserHandler
		}

		val intAge = age.toInt()
		if (intAge < 1) {
			setError(
				ErrorInfo(
					"Invalid age",
					"Please enter a valid age (> 0)."
				)
			)
			return@addUserHandler
		}

		props.onAddUser(userName, intAge)
		setUserName("")
		setAge("")
	}

	val userNameChangeHandler: EventHandler = { event ->
		setUserName(event.target?.value ?: "")
	}
	val ageChangeHandler: EventHandler = { event ->
		setAge(event.target?.value ?: "")
	}
	val errorHandler: EventHandler = {
		setError(null)
	}

	if (error != null) {
		ErrorModal {
			attrs {
				title = error.title
				message = error.message
				onConfirm = errorHandler
			}
		}
	}

	Card {
		css { +AddUserStyles.input }

		form {
			attrs.onSubmitFunction = addUserHandler

			label {
				attrs["htmlFor"] = "username"
				+"Username"
			}
			input {
				attrs {
					id = "username"
					type = InputType.text
					value = userName
					onChangeFunction = userNameChangeHandler
				}
			}

			label {
				attrs["htmlFor"] = "age"
				+"Age (Years)"
			}
			input {
				attrs {
					id = "age"
					type = InputType.number
					value = age
					onChangeFunction = ageChangeHandler
				}
			}

			Button {
				attrs.type = ButtonType.submit
				+"Add User"
			}
		}
	}
}

private data class ErrorInfo(val title: String, val message: String)

private object AddUserStyles : StyleSheet("AddUserStyles") {

	val input by css {
		margin(2.rem, LinearDimension.auto)
		padding(1.rem)
		width = 90.pct
		maxWidth = 40.rem

		label {
			display = Display.block
			fontWeight = FontWeight.bold
			marginBottom = 0.5.rem
		}

		input {
			put("font", "inherit")
			display = Display.block
			width = 100.pct
			border(1.px, BorderStyle.solid, Color("#ccc"))
			padding(0.15.rem)
			marginBottom = 0.5.rem

			focus {
				outline = Outline.none
				borderColor = Color("#4f005f")
			}
		}
	}

}
