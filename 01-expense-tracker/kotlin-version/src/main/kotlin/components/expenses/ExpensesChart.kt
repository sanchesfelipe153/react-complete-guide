package components.expenses

import commons.utils.FunctionalComponentDelegate
import components.chart.DataPoint
import components.chart.chart
import model.Expense
import react.RProps

interface ExpensesChartProps : RProps {

	var expenses: List<Expense>

}

val expensesChart by FunctionalComponentDelegate<ExpensesChartProps> { props ->
	val chartDataPoints = listOf(
		DataPoint("Jan", 0),
		DataPoint("Feb", 0),
		DataPoint("Mar", 0),
		DataPoint("Apr", 0),
		DataPoint("May", 0),
		DataPoint("Jun", 0),
		DataPoint("Jul", 0),
		DataPoint("Aug", 0),
		DataPoint("Sep", 0),
		DataPoint("Oct", 0),
		DataPoint("Nov", 0),
		DataPoint("Dec", 0),
	)

	props.expenses.forEach {
		val expenseMonth = it.date.getMonth()
		chartDataPoints[expenseMonth].value =
			it.amount.toDouble() + chartDataPoints[expenseMonth].value.toDouble()
	}

	chart {
		attrs.dataPoints = chartDataPoints
	}
}
