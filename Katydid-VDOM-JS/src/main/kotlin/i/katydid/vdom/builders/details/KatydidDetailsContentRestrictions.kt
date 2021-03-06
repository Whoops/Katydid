//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.details

//---------------------------------------------------------------------------------------------------------------------

/**
 * Set of restrictions on content of a `<details>` element.
 */
internal class KatydidDetailsContentRestrictions {

    private var summaryAllowed = true

    ////

    /**
     * Confirms that a `<summary>` element is allowed. Changes this restriction so that a second one is not allowed.
     * @throws IllegalStateException if `<source>` is not allowed.
     */
    fun confirmSummaryAllowedThenDisallow() {
        check(summaryAllowed) { "Element type <summary> not allowed here" }
        summaryAllowed = false
    }

}

//---------------------------------------------------------------------------------------------------------------------

