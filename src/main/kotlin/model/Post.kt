package model

data class Post(
    val id: Int,
    val content: String,
    val author: User,
    val createdAt: Long,
    val replies: List<Post> = emptyList(),
    val reactions: List<String> = emptyList()
)