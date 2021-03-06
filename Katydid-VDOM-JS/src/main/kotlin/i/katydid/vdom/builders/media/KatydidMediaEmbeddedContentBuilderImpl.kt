//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package i.katydid.vdom.builders.media

import i.katydid.vdom.builders.KatydidContentRestrictions
import i.katydid.vdom.builders.KatydidEmbeddedContentBuilderImpl
import i.katydid.vdom.elements.KatydidHtmlElementImpl
import i.katydid.vdom.elements.embedded.KatydidSource
import i.katydid.vdom.elements.embedded.KatydidTrack
import o.katydid.vdom.builders.KatydidAttributesContentBuilder
import o.katydid.vdom.builders.media.KatydidMediaEmbeddedContentBuilder
import o.katydid.vdom.types.EDirection
import o.katydid.vdom.types.ETrackKind
import o.katydid.vdom.types.MimeType

//---------------------------------------------------------------------------------------------------------------------

/**
 * Builder DSL to create the contents of a media element.
 *
 * @constructor Constructs a new builder for the contents of a `<audio>` or `<video>` element.
 * @param itsElement the element whose content is being built.
 * @param itsContentRestrictions restrictions on content enforced at run time.
 * @param itsDispatchMessages dispatcher of event handling results for when we want event handling to be reactive or Elm-like.
 */
internal class KatydidMediaEmbeddedContentBuilderImpl<Msg>(
    itsElement: KatydidHtmlElementImpl<Msg>,
    itsContentRestrictions: KatydidContentRestrictions = KatydidContentRestrictions(),
    itsMediaContentRestrictions: KatydidMediaContentRestrictions = KatydidMediaContentRestrictions(),
    itsDispatchMessages: (messages: Iterable<Msg>) -> Unit
) : KatydidEmbeddedContentBuilderImpl<Msg>(itsElement, itsContentRestrictions, itsDispatchMessages),
    KatydidMediaEmbeddedContentBuilder<Msg> {

    val mediaContentRestrictions = itsMediaContentRestrictions

    ////

    override fun source(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        lang: String?,
        media: String?,
        sizes: String?,
        spellcheck: Boolean?,
        src: String,
        srcset: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        type: MimeType?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidSource(this, selector, key, accesskey, contenteditable, dir, draggable,
                hidden, lang, media, sizes, spellcheck, src, srcset, style,
                tabindex, title, translate, type, defineAttributes)
        )
    }

    override fun track(
        selector: String?,
        key: Any?,
        accesskey: Char?,
        contenteditable: Boolean?,
        default: Boolean?,
        dir: EDirection?,
        draggable: Boolean?,
        hidden: Boolean?,
        kind: ETrackKind?,
        label: String?,
        lang: String?,
        spellcheck: Boolean?,
        src: String,
        srclang: String?,
        style: String?,
        tabindex: Int?,
        title: String?,
        translate: Boolean?,
        defineAttributes: KatydidAttributesContentBuilder<Msg>.() -> Unit
    ) {
        element.addChildNode(
            KatydidTrack(this, selector, key, accesskey, contenteditable, default, dir, draggable,
                hidden, kind, label, lang, spellcheck, src, srclang, style,
                tabindex, title, translate, defineAttributes)
        )
    }

}

//---------------------------------------------------------------------------------------------------------------------

