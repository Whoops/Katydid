//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.eventhandling.types

//---------------------------------------------------------------------------------------------------------------------

/**
 * Enumeration of DOM input event types.
 */
enum class EInputEventType {

    /** A "beforeinput" event. */
    BEFORE_INPUT,

    /** An "input" event. */
    INPUT;

    /**
     * The name of the event in the DOM.
     */
    val domName: String
        get() =
            when (this) {
                BEFORE_INPUT -> "beforeinput"
                INPUT        -> "input"
            }

}

//---------------------------------------------------------------------------------------------------------------------
