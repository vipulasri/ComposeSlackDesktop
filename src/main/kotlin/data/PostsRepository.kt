package data

import model.Post
import model.User

object PostsRepository {

    val posts = listOf(
        Post(
            id = 1,
            content = "Has anyone ever tried encashing esops of a private company/startup. Had a few questions to ask. Would be of great help.",
            author = User(
                1,
                "John Damon",
                "people/person_2.jpg",
            ),
            timestamp = System.currentTimeMillis()
        ),
        Post(
            id = 2,
            content = "Has anyone ever tried encashing esops of a private company/startup. Had a few questions to ask. Would be of great help.",
            author = User(
                1,
                "John Damon",
                "people/person_2.jpg",
            ),
            timestamp = System.currentTimeMillis(),
            reactions = listOf(
                "😄",
                "😄",
                "💯"
            )
        )
    )

}