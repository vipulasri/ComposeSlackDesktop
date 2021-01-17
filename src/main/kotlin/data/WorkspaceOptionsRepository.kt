package data

import Icons
import model.*
import theme.SlackColors

object WorkspaceOptionsRepository {

    private val generalOptions = listOf(
        WorkspaceOption(
            id = 1,
            name = "Threads",
            image = Icons.directMessage,
            emptyContent = ContentOption(
                iconColor = SlackColors.emptyThread,
                title = "Tend to your threads",
                message = "Threads you’re involved in will be collected right here."
            )
        ),
        WorkspaceOption(
            id = 2,
            name = "All DMs",
            image = Icons.chat,
        ),
        WorkspaceOption(
            id = 3,
            name = "Mentions & reactions",
            image = Icons.mention,
            emptyContent = ContentOption(
                iconColor = SlackColors.emptyMention,
                title = "See new activity in real time",
                message = "When people react to your messages or mention you or your\nkeywords, you’ll see it here."
            )
        ),
        WorkspaceOption(
            id = 4,
            name = "Saved items",
            image = Icons.bookmark,
            emptyContent = ContentOption(
                iconColor = SlackColors.emptySaved,
                title = "Add messages and files to come back to later",
                message = "Mark your to-dos or save something for another time. Only you\ncan see your saved items, so use them however you’d like."
            )
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
            Icons.hash,
            createdBy = users.first(),
            createdAt = System.currentTimeMillis()
        ),
        ChannelOption(
            2,
            "intro",
            Icons.hash,
            createdBy = users.first(),
            createdAt = System.currentTimeMillis()
        ),
        ChannelOption(
            3,
            "general",
            Icons.hash,
            createdBy = users.first(),
            createdAt = System.currentTimeMillis()
        ),
        ChannelOption(
            4,
            "help",
            Icons.hash,
            createdBy = users.first(),
            createdAt = System.currentTimeMillis()
        ),
        ChannelOption(
            5,
            "random",
            Icons.hash,
            createdBy = users.first(),
            createdAt = System.currentTimeMillis()
        )
    )

    private val directMessages = listOf(
        DMOption(
            user = slackbotUser
        ),
        DMOption(
            user = currentUser,
            isOnline = true
        ),
        DMOption(
            user = users[2],
            isOnline = true
        ),
        DMOption(
            user = users[3],
            isOnline = false
        ),
    )

    val options = WorkspaceOptionUiModel(
        general = generalOptions,
        channels = channels,
        messages = directMessages
    )

}