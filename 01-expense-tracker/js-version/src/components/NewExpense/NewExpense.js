import { useState } from 'react'
import { v4 as uuidv4 } from 'uuid'

import ExpenseForm from './ExpenseForm'

import './NewExpense.css'

const NewExpense = (props) => {
	const [showForm, setShowForm] = useState(false)

	if (!showForm) {
		const addNewExpenseHandler = () => {
			setShowForm(true)
		}

		return (
			<div className="new-expense">
				<button onClick={addNewExpenseHandler}>Add New Expense</button>
			</div>
		)
	}

	const saveExpenseDataHandler = (enteredExpenseData) => {
		const expenseData = {
			...enteredExpenseData,
			id: uuidv4(),
		}
		props.onAddExpense(expenseData)
		setShowForm(false)
	}
	const onCancelHandler = () => {
		setShowForm(false)
	}

	return (
		<div className="new-expense">
			<ExpenseForm
				onSaveExpenseData={saveExpenseDataHandler}
				onCancel={onCancelHandler}
			/>
		</div>
	)
}

export default NewExpense
