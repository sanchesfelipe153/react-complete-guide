package commons.utils

import kotlinx.css.RuleSet
import react.RElementBuilder
import react.RProps

interface RPropsWithCSS : RProps {

	var ruleSet: RuleSet?

}

fun RElementBuilder<RPropsWithCSS>.css(handler: RuleSet) {
	attrs.ruleSet = handler
}
