package model

data class User(
    val id: Int,
    val name: String,
    val image: String,
    val username: String = name
)

val users = listOf(
    User(
        id = 1,
        name = "Vipul Asri",
        image = "people/vipulasri.jpg",
        username = "vipulasri"
    ),
    User(
        id = 2,
        name = "John Damon",
        image = "people/person_1.jpg",
        username = "john.damon"
    ),
    User(
        id = 3,
        name = "Matt Andrews",
        image = "people/person_2.jpg",
        username = "matt_andrews"
    ),
    User(
        id = 4,
        name = "Tom Caprio",
        image = "people/person_3.jpg",
        username = "tom-caprio"
    )
)

val currentUser = users.first()

val slackbotUser = User(
    id = 5,
    name = "Slackbot",
    image = "slackbot.png",
    username = "slackbot"
)