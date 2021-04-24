import { v4 as uuidv4 } from 'uuid'

import ExpenseForm from './ExpenseForm'

import './NewExpense.css'

const NewExpense = (props) => {
	const saveExpenseDataHandler = (enteredExpenseData) => {
		const expenseData = {
			...enteredExpenseData,
			id: uuidv4(),
		}
		props.onAddExpense(expenseData)
	}

	return (
		<div className="new-expense">
			<ExpenseForm onSaveExpenseData={saveExpenseDataHandler} />
		</div>
	)
}

export default NewExpense
