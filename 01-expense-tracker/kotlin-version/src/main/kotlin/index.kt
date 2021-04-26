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
			fontFamily = "'Noto Sans JP', sans-serif"
		}

		body {
			margin(0.px)
			backgroundColor = Color("#3f3f3f")
		}

	}

	window.onload = {
		render(document.getElementById("root")) {
			app {}
		}
	}

}
