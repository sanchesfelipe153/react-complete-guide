rootProject.name = "react-complete-guide"

include(":kotlin-commons")

include(":expense-tracker")
project(":expense-tracker").projectDir = file("01-expense-tracker/kotlin-version")
