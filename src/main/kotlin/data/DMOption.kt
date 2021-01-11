package data

data class DMOption(
    val _id: Int,
    val _name: String,
    val _image: String,
    val isOnline: Boolean? = null
) : WorkspaceOption(_id, _name, _image, WorkspaceOptionType.DirectMessage)

val directMessages = listOf(
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