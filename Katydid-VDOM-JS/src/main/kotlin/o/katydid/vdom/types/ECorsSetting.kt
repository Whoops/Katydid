//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package o.katydid.vdom.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of allowed values for a CORS setting attribute.
 * See https://www.w3.org/TR/html5/infrastructure.html#cors-settings-attribute.
 */
@Suppress("EnumEntryName")
enum class ECorsSetting(
    private val html: String
) {

    /** The "anonymous" attribute value. */
    anonymous("anonymous"),

    /** The "use-credentials" attribute value. */
    useCredentials("use-credentials");

    ////

    /** @return the HTML attribute text for this direction. */
    fun toHtmlString() =
        html

}

//---------------------------------------------------------------------------------------------------------------------

