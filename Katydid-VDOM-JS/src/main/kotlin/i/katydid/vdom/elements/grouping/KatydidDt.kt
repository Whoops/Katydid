//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.elements.grouping

import i.katydid.vdom.builders.miscellaneous.KatydidDescriptionListContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import o.katydid.vdom.builders.KatydidFlowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for a <dt> element.
 */
internal class KatydidDt<Msg>(
    descriptionListContent: KatydidDescriptionListContentBuilderImpl<Msg>,
    selector: String?,
    key: Any?,
    accesskey: Char?,
    contenteditable: Boolean?,
    dir: EDirection?,
    draggable: Boolean?,
    hidden: Boolean?,
    lang: String?,
    spellcheck: Boolean?,
    style: String?,
    tabindex: Int?,
    title: String?,
    translate: Boolean?,
    defineContent: KatydidFlowContentBuilder<Msg>.() -> Unit
) : KatydidHtmlElementImpl<Msg>(selector, key, accesskey, contenteditable, dir, draggable,
    hidden, lang, spellcheck, style, tabindex, title, translate) {

    init {
        descriptionListContent.flowContent(this).defineContent()
        this.freeze()
    }

    ////

    override val nodeName = "DT"

}

//---------------------------------------------------------------------------------------------------------------------
