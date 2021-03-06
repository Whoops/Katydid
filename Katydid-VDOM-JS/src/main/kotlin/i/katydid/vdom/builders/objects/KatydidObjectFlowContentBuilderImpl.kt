//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.objects

import i.katydid.vdom.builders.KatydidAttributesContentBuilderImpl
import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidFlowContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.embedded.KatydidParam
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.objects.KatydidObjectFlowContentBuilder
import o.katydid.vdom.types.EDirection

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of an object element.
 *
 * @constructor Constructs a new builder for the contents of an `<object>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidObjectFlowContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidFlowContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidObjectFlowContentBuilder<Msg> {

    override fun param(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        name: String?,
        spellcheck: Boolean?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        value: String?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        contentRestrictions.confirmParamAllowed();

        element.addChildNode(
            KatydidParam(this, selector, key, accesskey, contenteditable, dir,
                draggable, hidden, lang, name, spellcheck, style,
                tabindex, title, translate, value, defineAttributes)
        )
    }

    /**
     * Creates a new attributes content builder for the given child [element]. Does not have the side effect of
     * preventing further `<param>` elements.
     */
    fun paramAttributesContent(element: KatydidParam<Msg>): KatydidAttributesContentBuilderImpl<Msg> {
        return KatydidAttributesContentBuilderImpl(element, dispatchMessages)
    }

}

//---------------------------------------------------------------------------------------------------------------------

