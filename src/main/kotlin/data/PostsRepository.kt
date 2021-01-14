package data

import model.Post
import model.users
import java.util.concurrent.TimeUnit

object PostsRepository {

    val posts = listOf(
        Post(
            id = 1,
            content = "Has anyone ever tried encashing esops of a private company/startup. Had a few questions to ask. Would be of great help.",
            author = users[1],
            createdAt = System.currentTimeMillis()
        ),
        Post(
            id = 2,
            content = "Has anyone ever tried encashing esops of a private company/startup. Had a few questions to ask. Would be of great help.",
            author = users[2],
            createdAt = System.currentTimeMillis().plus(TimeUnit.DAYS.toMillis(2)),
            reactions = listOf(
                "😄",
                "😄",
                "💯"
            )
        )
    ).sortedBy { it.createdAt }

}