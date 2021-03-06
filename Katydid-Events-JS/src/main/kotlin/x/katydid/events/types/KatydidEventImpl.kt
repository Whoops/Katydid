//
// (C) Copyright 2018-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package /*js*/x.katydid.events.types

import o.katydid.events.types.KatydidEvent
import x.katydid.vdom.dom.events.Event

//---------------------------------------------------------------------------------------------------------------------

open class KatydidEventImpl(
    private val event: Event
) : KatydidEvent {
    override val isDefaultPrevented : Boolean
        get() = event.defaultPrevented

    override val isPropagationStopped : Boolean
        get() = false // TODO: need to track it ourself

    ////

    override fun <T> getTargetAttribute(attrName: String): T {
        return event.target.asDynamic()[attrName] as T
    }

    override fun preventDefault() {
        event.preventDefault()
    }

    override fun stopPropagation() {
        event.stopPropagation()
    }

    override fun <T> setTargetAttribute(attrName: String, value: T) {
        event.target.asDynamic()[attrName] = value
    }

}

//---------------------------------------------------------------------------------------------------------------------

