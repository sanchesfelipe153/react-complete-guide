import commons.utils.FunctionalComponentDelegate
import components.users.AddUser
import components.users.UserData
import components.users.UsersList
import external.uuid.uuidV4
import react.RProps
import react.dom.div
import react.rawUseState

val App by FunctionalComponentDelegate<RProps> {
	val (users, setUsers) = rawUseState(emptyList<UserData>())

	val addUserHandler = { name: String, age: Int ->
		setUsers { oldValue: List<UserData> ->
			val newValue = ArrayList(oldValue)
			newValue.add(UserData(uuidV4(), name, age))
			newValue
		}
	}

	div {
		AddUser {
			attrs.onAddUser = addUserHandler
		}
		UsersList {
			attrs.users = users as List<UserData>
		}
	}
}
