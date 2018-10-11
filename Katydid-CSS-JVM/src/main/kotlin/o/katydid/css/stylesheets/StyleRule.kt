//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.stylesheets

import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.StyleBuilderDsl
import o.katydid.css.styles.makeStyle

//---------------------------------------------------------------------------------------------------------------------

/**
 * Class representing one style rule (selectors plus style properties) in a larger style sheet.
 */
@StyleBuilderDsl
class StyleRule(
    parent: StyleBlock,
    style: Style = makeStyle {}
) : AbstractStyleRule(parent, style) {

    override fun copy(parentOfCopy: StyleBlock): StyleRule {
        val result = StyleRule(parentOfCopy)
        result.addSelectors(selectors)
        result.include(this)
        result.addNestedBlocks(nestedBlocks.map { b -> b.copy(result) })
        return result
    }

    override fun extend(vararg placeholderNames: String) {

        for (placeholderName in placeholderNames) {
            val placeholder = parent.findPlaceholder(placeholderName)
                ?: throw IllegalArgumentException("Unknown placeholder rule to be extended: '$placeholderName'.")

            placeholder.addSelectors(selectors)
        }

    }

    /** Builds a placeholder rule from a selector [name] and the [build] function for the rule. */
    fun placeholder(name: String, build: PlaceholderRule.() -> Unit) {

        require(findPlaceholder(name) == null) { "Duplicate placeholder name not allowed: '$this'." }

        // Create the new placeholder rule.
        val result = PlaceholderRule(this, name)

        // Nest the new placeholder in this style sheet.
        this.addNestedBlock(result)

        // Build its style.
        result.build()

    }

}

//---------------------------------------------------------------------------------------------------------------------

