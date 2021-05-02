package components.users

import commons.utils.FunctionalComponentDelegate
import commons.utils.css
import components.ui.Card
import kotlinx.css.*
import kotlinx.css.properties.border
import react.RProps
import react.dom.key
import react.dom.li
import react.dom.ul
import styled.StyleSheet

interface UsersListProps : RProps {

	var users: List<UserData>

}

val UsersList by FunctionalComponentDelegate<UsersListProps> { props ->
	Card {
		css { +UsersListStyles.users }

		ul {
			props.users.renderEach {
				li {
					attrs.key = it.id
					+"${it.name} (${it.age} years old)"
				}
			}
		}
	}
}

private object UsersListStyles : StyleSheet("UsersListStyles") {

	val users by css {
		margin(2.rem, LinearDimension.auto)
		width = 90.pct
		maxWidth = 40.rem

		ul {
			listStyleType = ListStyleType.none
			padding(1.rem)
		}

		li {
			border(1.px, BorderStyle.solid, Color("#ccc"))
			margin(0.5.rem, 0.px)
			padding(0.5.rem)
		}
	}

}
