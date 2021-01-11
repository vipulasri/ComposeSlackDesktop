package data

import model.ChannelOption
import model.DMOption
import model.WorkspaceOption
import model.WorkspaceOptionUiModel

object WorkspaceOptionsRepository {

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

    private val channels = listOf(
        ChannelOption(
            1,
            "announcements",
            Icons.hash
        ),
        ChannelOption(
            2,
            "intro",
            Icons.hash
        ),
        ChannelOption(
            3,
            "general",
            Icons.hash
        ),
        ChannelOption(
            4,
            "help",
            Icons.hash
        ),
        ChannelOption(
            5,
            "random",
            Icons.hash
        )
    )

    private val directMessages = listOf(
        DMOption(
            1,
            "Slackbot",
            "slackbot.png"
        ),
        DMOption(
            2,
            "Vipul Asri",
            "people/person_1.jpg",
            isOnline = true
        ),
        DMOption(
            3,
            "John Damon",
            "people/person_2.jpg",
            isOnline = true
        ),
        DMOption(
            4,
            "Matt Andrews",
            "people/person_3.jpg",
            isOnline = false
        )
    )

    val options = WorkspaceOptionUiModel(
        general = generalOptions,
        channels = channels,
        messages = directMessages
    )

}