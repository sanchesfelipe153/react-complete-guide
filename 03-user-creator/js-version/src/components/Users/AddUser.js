import { useState } from 'react'

import Button from '../UI/Button'
import Card from '../UI/Card'
import ErrorModal from '../UI/ErrorModal'

import classes from './AddUser.module.css'

const AddUser = ({ onAddUser }) => {
	const [userName, setUserName] = useState('')
	const [age, setAge] = useState('')
	const [error, setError] = useState()

	const addUserHandler = (event) => {
		event.preventDefault()

		if (userName.trim().length === 0 || age.trim().length === 0) {
			setError({
				title: 'Invalid input',
				message:
					'Please enter a valid name and age (non-empty values).',
			})
			return
		}
		if (+age < 1) {
			setError({
				title: 'Invalid age',
				message: 'Please enter a valid age (> 0).',
			})
			return
		}

		onAddUser(userName, age)
		setUserName('')
		setAge('')
	}

	const userNameChangeHandler = (event) => {
		setUserName(event.target.value)
	}
	const ageChangeHandler = (event) => {
		setAge(event.target.value)
	}
	const errorHandler = () => {
		setError(null)
	}

	return (
		<>
			{error && (
				<ErrorModal
					title={error.title}
					message={error.message}
					onConfirm={errorHandler}
				/>
			)}
			<Card className={classes.input}>
				<form onSubmit={addUserHandler}>
					<label htmlFor="username">Username</label>
					<input
						id="username"
						type="text"
						value={userName}
						onChange={userNameChangeHandler}
					/>
					<label htmlFor="age">Age (Years)</label>
					<input
						id="age"
						type="number"
						value={age}
						onChange={ageChangeHandler}
					/>
					<Button type="submit">Add User</Button>
				</form>
			</Card>
		</>
	)
}

export default AddUser
