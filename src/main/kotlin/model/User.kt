package model

data class User(
    val id: Int,
    val name: String,
    val image: String,
    val username: String = name
)

val slackbotUser = User(
    id = 1,
    name = "Slackbot",
    image = "slackbot.png",
    username = "slackbot"
)

val currentUser = User(
    id = 2,
    name = "Vipul Asri",
    image = "people/vipulasri.jpg",
    username = "vipulasri"
)

val users = listOf(
    User(
        id = 3,
        name = "John Damon",
        image = "people/person_1.jpg",
        username = "john.damon"
    ),
    User(
        id = 4,
        name = "Matt Andrews",
        image = "people/person_2.jpg",
        username = "matt_andrews"
    ),
    User(
        id = 5,
        name = "Tom Caprio",
        image = "people/person_3.jpg",
        username = "tom-caprio"
    ),
    User(
        id = 6,
        name = "Leelo Daniel",
        image = "people/person_4.jpg",
        username = "leelo"
    ),
    User(
        id = 7,
        name = "Zeenat Germana",
        image = "people/person_5.jpg",
        username = "zeenat"
    )
)