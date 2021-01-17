package data

import model.Message
import model.User
import model.currentUser
import model.slackbotUser
import java.util.concurrent.TimeUnit

object MessagesRepository {

    fun getMessages(conversationWith: User): List<Message> {

        if (conversationWith == slackbotUser) return getSlackbotMessages()
        if (conversationWith == currentUser) return getSelfMessages()

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

    private val slackbotMessageContent = listOf(
        "If you're not sure how to do something in Slack, just type your question below.",
        "To get the most out of Slack, it's good to be where the conversation's happening - in channels! You can always browse a full list by choosing Channels on the left",
        "👋Howdy! Starting today, I’ll occasionally suggest channels to join, star, or leave. The right set of channels will keep you both focused and informed.",
        "Ready to streamline your channel list? Below are a few channels you rarely interact with — it might be time to say au revoir 👋\n",
        "You asked me to remind you “meeting”."
    )

    private fun getSlackbotMessages(): List<Message> {
        val now = System.currentTimeMillis()
        return slackbotMessageContent.mapIndexed { index, content ->
            Message(
                index,
                content = content,
                author = slackbotUser,
                createdAt = now.addDays(index.toLong())
            )
        }
    }

    private val selfMessageContent = listOf(
        "Task - 963 - 1 day\n" +
                "Task - 984 - 2 hours\n" +
                "Task - 983 - 2 days\n" +
                "Task - 908 - 3 days\n" +
                "Task - 998 - 1 day",
        "Delete all the merged branches:\n" +
                "git branch --merged| egrep -v \"(^\\*|master|dev)\"",
        "Remove remote tracking of merged branches\n" +
                "git remote prune origin",
    )

    private fun getSelfMessages(): List<Message> {
        val now = System.currentTimeMillis()
        return selfMessageContent.mapIndexed { index, content ->
            Message(
                index,
                content = content,
                author = currentUser,
                createdAt = now.addDays(index.toLong())
            )
        }
    }

    private fun Long.addMinutes(minutes: Long): Long {
        return this.plus(TimeUnit.MINUTES.toMillis(minutes))
    }

    private fun Long.addDays(days: Long): Long {
        return this.plus(TimeUnit.DAYS.toMillis(days))
    }

}