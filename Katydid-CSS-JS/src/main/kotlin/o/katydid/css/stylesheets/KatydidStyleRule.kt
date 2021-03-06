//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.builders.KatydidStyleBuilderDsl

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@KatydidStyleBuilderDsl
interface KatydidStyleRule
    : KatydidAbstractStyleRule {

    /** Builds a placeholder rule from a selector [name] and the [build] function for the rule. */
    fun placeholder(name: String, build: KatydidPlaceholderRule.() -> Unit)

}

//---------------------------------------------------------------------------------------------------------------------

