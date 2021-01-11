package data

import Icons

sealed class WorkspaceOptionType {
    object General : WorkspaceOptionType()
    object Channel : WorkspaceOptionType()
    object DirectMessage : WorkspaceOptionType()
}

open class WorkspaceOption(
    val id: Int,
    val name: String,
    val image: String,
    val type: WorkspaceOptionType = WorkspaceOptionType.General
)

data class WorkspaceOptionUiModel(
    val general: List<WorkspaceOption>,
    val channels: List<WorkspaceOption>,
    val messages: List<WorkspaceOption>
)

private val generalOptions = listOf(
    WorkspaceOption(
        id = 1,
        name = "Threads",
        image = Icons.directMessage
    ),
    WorkspaceOption(
        id = 2,
        name = "All DMs",
        image = Icons.chat
    ),
    WorkspaceOption(
        id = 3,
        name = "Mentions & reactions",
        image = Icons.mention
    ),
    WorkspaceOption(
        id = 4,
        name = "Saved items",
        image = Icons.bookmark
    ),
    WorkspaceOption(
        id = 5,
        name = "More",
        image = Icons.verticalDots
    ),
)

val uiModel = WorkspaceOptionUiModel(
    general = generalOptions,
    channels = channels,
    messages = directMessages
)
