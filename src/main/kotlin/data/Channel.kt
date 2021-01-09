package data

data class Channel(
    val id: Int,
    val name: String,
    val image: String
)

val channels = listOf(
    Channel(
        1,
        "announcements",
        Icons.hash
    ),
    Channel(
        2,
        "intro",
        Icons.hash
    ),
    Channel(
        3,
        "general",
        Icons.hash
    ),
    Channel(
        4,
        "help",
        Icons.hash
    ),
    Channel(
        5,
        "random",
        Icons.hash
    )
)