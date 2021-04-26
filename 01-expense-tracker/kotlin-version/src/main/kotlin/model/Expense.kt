package model

import kotlin.js.Date

data class Expense(
	val id: String, val title: String, val amount: Number, val date: Date
)
