package data

data class DirectMessage(
    val id: Int,
    val name: String,
    val image: String,
    val isOnline: Boolean? = null
)

val directMessages = listOf(
    DirectMessage(
        1,
        "Slackbot",
        "slackbot.png"
    ),
    DirectMessage(
        2,
        "Vipul Asri",
        "people/person_1.jpg",
        isOnline = true
    ),
    DirectMessage(
        3,
        "John Damon",
        "people/person_2.jpg",
        isOnline = true
    ),
    DirectMessage(
        4,
        "Matt Andrews",
        "people/person_3.jpg",
        isOnline = false
    )
)