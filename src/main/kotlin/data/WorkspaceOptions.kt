package data

import Icons

data class WorkspaceOption(
    val id: Int,
    val name: String,
    val image: String,
    val channels: List<Channel> = arrayListOf()
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
        name = "Channels",
        image = Icons.caretDown,
        channels = listOf(
            Channel(
                1,
                "announcements",
                Icons.hash
            ),
            Channel(
                2,
                "intro",
                Icons.hash
            ),
            Channel(
                3,
                "general",
                Icons.hash
            ),
            Channel(
                4,
                "help",
                Icons.hash
            ),
            Channel(
                5,
                "random",
                Icons.hash
            )
        )
    ),
)
