//
// (C) Copyright 2017-2018 Martin E. Nordberg III
// Apache 2.0 License
//

package o.org.katydom.internal.concretenodes.grouping

import o.org.katydom.abstractnodes.KatyDomHtmlElement
import o.org.katydom.builders.KatyDomFlowContentBuilder
import o.org.katydom.internal.builders.lists.KatyDomOrderedListContentBuilderImpl
import o.org.katydom.internal.builders.lists.KatyDomUnorderedListContentBuilderImpl
import o.org.katydom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Virtual node for an <li> element.
 */
internal class KatyDomLi<Msg> : KatyDomHtmlElement<Msg> {

    constructor(
        listContent: KatyDomOrderedListContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: Int?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        setNumberAttribute("value", value)

        listContent.flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()

    }

    constructor(
        listContent: KatyDomUnorderedListContentBuilderImpl<Msg>,
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        hidden: Boolean?,
        lang: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineContent: KatyDomFlowContentBuilder<Msg>.() -> Unit
    ) : super(selector, key, accesskey, contenteditable, dir,
              hidden, lang, spellcheck, style, tabindex, title, translate) {

        listContent.flowContent.withNoAddedRestrictions(this).defineContent()
        this.freeze()

    }

    ////

    override val nodeName = "LI"

}

//---------------------------------------------------------------------------------------------------------------------