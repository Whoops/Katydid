//
// (C) Copyright 2017-2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.forms

import i.katydid.vdom.builders.miscellaneous.KatydidSelectContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.miscellaneous.KatydidOptGroupContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an `<optgroup>` element.
 */
internal class KatydidOptGroup<Msg>(
    selectContent: KatydidSelectContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    disabled: Boolean?,
    draggable: Boolean?,
    hidden: Boolean?,
    label: String,
    lang: String?,
    name: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatydidOptGroupContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key ?: name, accesskey, contenteditable, dir, draggable,
                                hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        require(!label.isEmpty()) { "Attribute label may not be an empty string." }

        setBooleanAttribute("disabled", disabled)
        setAttribute("label", label)

        selectContent.optGroupContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "OPTGROUP"

}

//---------------------------------------------------------------------------------------------------------------------

