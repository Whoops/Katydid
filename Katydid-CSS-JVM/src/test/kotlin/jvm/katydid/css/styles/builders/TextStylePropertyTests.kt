//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package jvm.katydid.css.styles.builders

import o.katydid.css.colors.antiquewhite
import o.katydid.css.colors.red
import o.katydid.css.measurements.em
import o.katydid.css.measurements.percent
import o.katydid.css.styles.Style
import o.katydid.css.styles.builders.*
import o.katydid.css.styles.style
import o.katydid.css.types.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//---------------------------------------------------------------------------------------------------------------------

@Suppress("RemoveRedundantBackticks")
class TextStylePropertyTests {

    private fun checkStyle(
        expectedCss: String,
        build: Style.() -> Unit
    ) {
        assertEquals(expectedCss, style(build).toString())
    }

    @Test
    fun `Nested text align properties convert to correct CSS`() {

        checkStyle("text-align: center;") { text { align(ETextAlign.center) } }
        checkStyle("text-decoration: none;") { text { decoration(ENone.none) } }
        checkStyle("text-decoration: underline;") { text { decoration(ETextDecorationLine.underline) } }
        checkStyle("text-decoration: underline wavy red overline;") { text { decoration(ETextDecorationLine.underline, ETextDecorationStyle.wavy, red, moreLines = *arrayOf(ETextDecorationLine.overline)) } }
        checkStyle("text-decoration-color: antiquewhite;") { text { decorationColor(antiquewhite) } }
        checkStyle("text-decoration-line: none;") { text { decorationLine(ENone.none) } }
        checkStyle("text-decoration-line: underline overline;") { text { decorationLine(ETextDecorationLine.underline, ETextDecorationLine.overline) } }
        checkStyle("text-decoration-style: dotted;") { text { decorationStyle(ETextDecorationStyle.dotted) } }
        checkStyle("text-decoration-color: antiquewhite;") { text { decoration { color(antiquewhite) } } }
        checkStyle("text-decoration-line: none;") { text { decoration { line(ENone.none) } } }
        checkStyle("text-decoration-line: underline overline;") { text { decoration { line(ETextDecorationLine.underline, ETextDecorationLine.overline) } } }
        checkStyle("text-decoration-style: dotted;") { text { decoration { style(ETextDecorationStyle.dotted) } } }
        checkStyle("text-indent: 3em;") { text { indent(3.em) } }
        checkStyle("text-indent: 3%;") { text { indent(3.percent) } }
        checkStyle("text-overflow: ellipsis;") { text { overflow(ETextOverflow.ellipsis) } }
        checkStyle("text-transform: lowercase;") { text { transform(ETextTransform.lowercase) } }

    }

    @Test
    fun `Text align properties convert to correct CSS`() {

        checkStyle("text-align: center;") { textAlign(ETextAlign.center) }
        checkStyle("text-align: end;") { textAlign(ETextAlign.end) }
        checkStyle("text-align: justify;") { textAlign(ETextAlign.justify) }
        checkStyle("text-align: justify-all;") { textAlign(ETextAlign.justifyAll) }
        checkStyle("text-align: left;") { textAlign(ETextAlign.left) }
        checkStyle("text-align: match-parent;") { textAlign(ETextAlign.matchParent) }
        checkStyle("text-align: right;") { textAlign(ETextAlign.right) }
        checkStyle("text-align: start;") { textAlign(ETextAlign.start) }

    }

    @Test
    fun `Text decoration properties convert to correct CSS`() {

        checkStyle("text-decoration: none;") { textDecoration(ENone.none) }
        checkStyle("text-decoration: underline;") { textDecoration(ETextDecorationLine.underline) }
        checkStyle("text-decoration: underline line-through;") { textDecoration(ETextDecorationLine.underline, moreLines = *arrayOf(ETextDecorationLine.lineThrough)) }
        checkStyle("text-decoration: underline wavy red overline;") { textDecoration(ETextDecorationLine.underline, ETextDecorationStyle.wavy, red, moreLines = *arrayOf(ETextDecorationLine.overline)) }

        checkStyle("text-decoration-color: antiquewhite;") { textDecorationColor(antiquewhite) }

        checkStyle("text-decoration-line: none;") { textDecorationLine(ENone.none) }
        checkStyle("text-decoration-line: line-through;") { textDecorationLine(ETextDecorationLine.lineThrough) }
        checkStyle("text-decoration-line: overline;") { textDecorationLine(ETextDecorationLine.overline) }
        checkStyle("text-decoration-line: underline;") { textDecorationLine(ETextDecorationLine.underline) }
        checkStyle("text-decoration-line: underline overline;") { textDecorationLine(ETextDecorationLine.underline, ETextDecorationLine.overline) }

        checkStyle("text-decoration-style: dashed;") { textDecorationStyle(ETextDecorationStyle.dashed) }
        checkStyle("text-decoration-style: dotted;") { textDecorationStyle(ETextDecorationStyle.dotted) }
        checkStyle("text-decoration-style: double;") { textDecorationStyle(ETextDecorationStyle.double) }
        checkStyle("text-decoration-style: solid;") { textDecorationStyle(ETextDecorationStyle.solid) }
        checkStyle("text-decoration-style: wavy;") { textDecorationStyle(ETextDecorationStyle.wavy) }
    }

    @Test
    fun `Text indent properties convert to correct CSS`() {

        checkStyle("text-indent: 3em;") { textIndent(3.em) }
        checkStyle("text-indent: 3%;") { textIndent(3.percent) }

    }

    @Test
    fun `Text overflow properties convert to correct CSS`() {

        checkStyle("text-overflow: clip;") { textOverflow(ETextOverflow.clip) }
        checkStyle("text-overflow: ellipsis;") { textOverflow(ETextOverflow.ellipsis) }

    }

    @Test
    fun `Text transform properties convert to correct CSS`() {

        checkStyle("text-transform: capitalize;") { textTransform(ETextTransform.capitalize) }
        checkStyle("text-transform: lowercase;") { textTransform(ETextTransform.lowercase) }
        checkStyle("text-transform: none;") { textTransform(ETextTransform.none) }
        checkStyle("text-transform: uppercase;") { textTransform(ETextTransform.uppercase) }
        checkStyle("text-transform: full-width;") { textTransform(ETextTransform.fullWidth) }

    }

}

//---------------------------------------------------------------------------------------------------------------------

