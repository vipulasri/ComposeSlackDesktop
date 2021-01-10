package data

import Icons

sealed class WorkspaceOptionType {
    object General : WorkspaceOptionType()
    class Channel(val items: List<data.Channel>) : WorkspaceOptionType()
    class DirectMessage(val items: List<data.DirectMessage>) : WorkspaceOptionType()
}

data class WorkspaceOption(
    val id: Int,
    val name: String,
    val image: String,
    val type: WorkspaceOptionType = WorkspaceOptionType.General
)

val options = listOf(
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
    WorkspaceOption(
        id = 6,
        name = "Channels",
        image = Icons.caretDown,
        type = WorkspaceOptionType.Channel(
            items = channels
        )
    ),
    WorkspaceOption(
        id = 7,
        name = "Direct messages",
        image = Icons.caretDown,
        type = WorkspaceOptionType.DirectMessage(
            items = directMessages
        )
    ),
)
