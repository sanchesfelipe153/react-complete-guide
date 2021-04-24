import { useState } from 'react'

import Card from '../UI/Card'
import ExpenseItem from './ExpenseItem'
import ExpensesFilter from './ExpensesFilter'

import './Expenses.css'

const Expenses = (props) => {
	const [filteredYear, setFilteredYear] = useState('2021')

	const filterChangeHandler = (year) => {
		setFilteredYear(year)
	}

	return (
		<div>
			<Card className="expenses">
				<ExpensesFilter
					selected={filteredYear}
					onChangeFilter={filterChangeHandler}
				/>

				{props.items.map((item) => (
					<ExpenseItem
						key={item.id}
						title={item.title}
						amount={item.amount}
						date={item.date}
					/>
				))}
			</Card>
		</div>
	)
}

export default Expenses
