package data

import model.Message
import model.User
import model.currentUser
import java.util.concurrent.TimeUnit

object MessagesRepository {

    fun getMessages(conversationWith: User): List<Message> {
        val now = System.currentTimeMillis()
        return listOf(
            Message(
                id = 1,
                content = "Hello, Good Morning",
                author = currentUser,
                createdAt = now.addMinutes(1)
            ),
            Message(
                id = 2,
                content = "Hey, How are you?",
                author = conversationWith,
                createdAt = now.addMinutes(2)
            ),
            Message(
                id = 3,
                content = "I am good. Actually, I wanted to take an update on the yesterday's task.",
                author = currentUser,
                createdAt = now.addMinutes(3)
            ),
            Message(
                id = 4,
                content = "Yeah, the task is complete and I have raised the PR for the same",
                author = conversationWith,
                createdAt = now.addMinutes(4),
                reactions = listOf(
                    "👍",
                )
            ),
            Message(
                id = 5,
                content = "Great, I will have a look and review it. ",
                author = currentUser,
                createdAt = now.addMinutes(5)
            ),
        )
    }

    private fun Long.addMinutes(minutes: Long): Long {
        return this.plus(TimeUnit.MINUTES.toMillis(minutes))
    }

}