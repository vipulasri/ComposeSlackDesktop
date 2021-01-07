package data

data class Workspace(
    val id: Int,
    val name: String,
    val image: String
)

val workspaces = listOf(
    Workspace(
        id = 1,
        name = "Mutual Mobile",
        image = "mutualmobile.png"
    ),
    Workspace(
        id = 2,
        name = "Blrdroid",
        image = "blrdroid.png"
    ),
    Workspace(
        id = 3,
        name = "GDG Hyderabad",
        image = "gdghyd.png"
    ),
    Workspace(
        id = 4,
        name = "Kotlinlang",
        image = "kotlin.png"
    )
)