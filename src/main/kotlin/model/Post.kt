package model

data class Post(
    val id: Int,
    val content: String,
    val author: User,
    val timestamp: Long,
    val replies: List<Post> = emptyList(),
    val reactions: List<String> = emptyList()
)

data class User(
    val id: Int,
    val name: String,
    val image: String
)