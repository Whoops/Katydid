//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.css.types

/** Enumeration of options for the 'visibility' property. */
@Suppress("EnumEntryName")
enum class EVisibility(
    private val css: String
) {

    /** The generated box is visible. */
    visible("visible"),

    /**
     * The generated box is invisible (fully transparent, nothing is drawn), but still affects layout. Furthermore,
     * descendants of the element will be visible if they have 'visibility: visible'.
     */
    hidden("hidden"),

    /**
     * Please consult the section on dynamic row and column effects in tables. If used on elements other than rows,
     * row groups, columns, or column groups, 'collapse' has the same meaning as 'hidden'.
     */
    collapse("collapse");

    ////

    /** @return the CSS attribute text for this visibility option. */
    override fun toString() =
        css

    ////

    companion object {

        fun fromString(option: String?) =
            when (option) {
                null       -> null
                "collapse" -> collapse
                "hidden"   -> hidden
                "visible"  -> visible
                else       -> throw IllegalArgumentException("Unknown visibility option: '$option'.")
            }

    }

}
