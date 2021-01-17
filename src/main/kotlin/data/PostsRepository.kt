package data

import model.Message
import model.users
import java.util.concurrent.TimeUnit

object PostsRepository {

    private val content = listOf(
        "Has anyone ever tried encashing esops of a private company/startup. Had a few questions to ask. Would be of great help.",
        "what would be the most simple infinite loop for an infinite animation ? is it possible to animate without reading a state ?",
        "Hi everyone, wanted to know how you guys version your app's \"versionName\". What standard or convention do you follow.",
        "If I want to create a android library then what are the steps need to follow for that and how it is different from creating an app?",
        "Book recommendations for unit testing and things around it? Thanks",
        "Is there a tool which can be used for load/performance testing for a server running on express.js?"
    )

    val posts = listOf(
        Message(
            id = 1,
            content = content.first(),
            author = users[0],
            createdAt = System.currentTimeMillis()
        ),
        Message(
            id = 2,
            content = content[2],
            author = users[2],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(2)),
            reactions = listOf(
                "😄",
                "😄",
                "💯"
            )
        ),
        Message(
            id = 3,
            content = content[1],
            author = users[1],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(2)),
            reactions = listOf(
                "🤔",
            )
        ),
        Message(
            id = 4,
            content = content[3],
            author = users[3],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(6)),
            reactions = listOf(
                "👍",
                "👍",
                "👍",
            )
        ),
        Message(
            id = 5,
            content = content[5],
            author = users[4],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(4)),
            reactions = listOf(
                "👍",
                "👍",
                "👍",
            )
        ),
        Message(
            id = 6,
            content = content[4],
            author = users[4],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(2)),
            reactions = listOf(
                "💯",
            )
        )
    ).sortedBy { it.createdAt }
}