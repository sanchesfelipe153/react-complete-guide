import { useState } from 'react'

import Card from '../UI/Card'
import ExpensesFilter from './ExpensesFilter'
import ExpensesList from './ExpensesList'

import './Expenses.css'
import ExpensesChart from './ExpensesChart'

const Expenses = (props) => {
	const [filteredYear, setFilteredYear] = useState('2021')

	const filterChangeHandler = (year) => {
		setFilteredYear(year)
	}

	const filteredExpenses = props.items
		.filter((item) => item.date.getFullYear().toString() === filteredYear)
		.sort((a, b) => b.date.getTime() - a.date.getTime())

	return (
		<div>
			<Card className="expenses">
				<ExpensesFilter
					selected={filteredYear}
					onChangeFilter={filterChangeHandler}
				/>
				<ExpensesChart expenses={filteredExpenses} />

				<ExpensesList items={filteredExpenses} />
			</Card>
		</div>
	)
}

export default Expenses
