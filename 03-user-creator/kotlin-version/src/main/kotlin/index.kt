import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import react.dom.render
import styled.injectGlobal

fun main() {

	injectGlobal {

		universal {
			boxSizing = BoxSizing.borderBox
		}

		html {
			fontFamily = "sans-serif"
			background = "#1f1f1f"
		}

		body {
			margin(0.px)
		}

	}

	window.onload = {
		render(document.getElementById("root")) {
			App {}
		}
	}

}
