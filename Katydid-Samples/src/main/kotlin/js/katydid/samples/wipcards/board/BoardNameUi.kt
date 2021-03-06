//
// (C) Copyright 2019 Martin E. Nordberg III
// Apache 2.0 License
//

package js.katydid.samples.wipcards.board

import js.katydid.samples.wipcards.domain.model.Board
import js.katydid.samples.wipcards.domain.model.WipCardsDomain
import js.katydid.samples.wipcards.domain.update.RenameBoardAction
import js.katydid.samples.wipcards.infrastructure.Uuid
import o.katydid.css.colors.lightseagreen
import o.katydid.css.measurements.px
import o.katydid.css.styles.builders.*
import o.katydid.css.stylesheets.KatydidStyleSheet
import o.katydid.css.types.EDisplay
import o.katydid.css.types.EFontWeight
import o.katydid.css.types.EPosition
import o.katydid.events.eventhandling.*
import o.katydid.vdom.builders.KatydidFlowContentBuilder

//---------------------------------------------------------------------------------------------------------------------
// MODEL
//---------------------------------------------------------------------------------------------------------------------

/** Description of a WIP Cards board. */
data class BoardNameViewModel(

    val isEditButtonShown : Boolean = false,

    val isEditingInProgress : Boolean = false,

    val domain: WipCardsDomain,

    val boardUuid: Uuid<Board>

) {

    val name = domain.boardWithUuid(boardUuid)?.name ?: ""

}

//---------------------------------------------------------------------------------------------------------------------
// UPDATE
//---------------------------------------------------------------------------------------------------------------------

/** Message related to changing a board's name. */
sealed class BoardNameMsg

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is to be renamed. */
private class BoardNameRenameMsg(

    boardUuid: Uuid<Board>,
    oldName: String,
    newName: String

) : BoardNameMsg() {

    val action = RenameBoardAction(boardUuid, newName, oldName)

}

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is to be edited. */
private object BoardNameStartEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when the mouse is hovering over the board name. */
private object BoardNameStartHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board is no longer being edited. */
private object BoardNameStopEditingMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/** Message when a board name is no longer being hovered over. */
private object BoardNameStopHoveringMsg : BoardNameMsg()

//---------------------------------------------------------------------------------------------------------------------

/**
 * Creates a new board name state modified from given [boardName] by the given [message].
 */
fun updateBoardName(
    boardName: BoardNameViewModel,
    message: BoardNameMsg
): BoardNameViewModel {

    return when (message) {

        is BoardNameRenameMsg        -> boardName.copy(domain = message.action.apply(boardName.domain))

        is BoardNameStartEditingMsg  -> boardName.copy(isEditButtonShown = false, isEditingInProgress = true)

        is BoardNameStartHoveringMsg -> boardName.copy(isEditButtonShown = true)

        is BoardNameStopEditingMsg   -> boardName.copy(isEditingInProgress = false)

        is BoardNameStopHoveringMsg  -> boardName.copy(isEditButtonShown = false)

    }

}

//---------------------------------------------------------------------------------------------------------------------
// VIEW
//---------------------------------------------------------------------------------------------------------------------

private const val cssClassName = "wipcards-board-name"

//---------------------------------------------------------------------------------------------------------------------

/**
 * Generates the board name heading of the WIP Cards board.
 */
internal fun <Msg> KatydidFlowContentBuilder<Msg>.viewBoardName(
    boardName: BoardNameViewModel,
    makeMsg: (msg: BoardNameMsg) -> Msg
) {

    if (boardName.isEditingInProgress) {

        dialog(".$cssClassName", open = true) {

            inputText(value = boardName.name, autofocus = true) {

                onblur {
                    listOf(makeMsg(BoardNameStopEditingMsg))
                }

                onchange { event ->
                    val newValue = event.getTargetAttribute<String>("value").toString()
                    listOf(
                        makeMsg(BoardNameStopEditingMsg),
                        makeMsg(BoardNameRenameMsg(boardName.boardUuid, boardName.name, newValue))
                    )
                }

            }

        }

    }
    else {

        onmouseenter {
            listOf(makeMsg(BoardNameStartHoveringMsg))
        }

        onmouseleave {
            listOf(makeMsg(BoardNameStopHoveringMsg))
        }

        h1(".$cssClassName") {

            +boardName.name

            if (boardName.isEditButtonShown) {

                button {

                    onclick {
                        listOf(makeMsg(BoardNameStartEditingMsg))
                    }

                    +"Edit"

                }

            }

        }

    }

}

//---------------------------------------------------------------------------------------------------------------------
// STYLE
//---------------------------------------------------------------------------------------------------------------------

fun KatydidStyleSheet.boardNameStyles() {

    /* DIALOG */
    "dialog.$cssClassName" {

        backgroundColor(lightseagreen)
        borderColor(lightseagreen)
        display(EDisplay.inlineTable)
        padding(2.px)
        position(EPosition.relative)

        "input" {
            borderColor(lightseagreen)
            fontSize(22.px)
            fontWeight(EFontWeight.bold)
        }

    }

    /* H1 */
    "h1.$cssClassName" {

        fontSize(25.px)
        margin(5.px, 0.px, 5.px, 5.px)

    }

}

//---------------------------------------------------------------------------------------------------------------------

