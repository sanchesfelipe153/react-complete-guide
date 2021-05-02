import { useState } from 'react'
import { v4 as uuidv4 } from 'uuid'

import AddUser from './components/Users/AddUser'
import UsersList from './components/Users/UsersList'

const App = () => {
	const [users, setUsers] = useState([])

	const addUserHandler = (name, age) => {
		setUsers((oldValue) => [...oldValue, { name, age, id: uuidv4() }])
	}

	return (
		<div>
			<AddUser onAddUser={addUserHandler} />
			<UsersList users={users} />
		</div>
	)
}

export default App
