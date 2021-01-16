package model

data class Message(
    val id: Int,
    val content: String,
    val author: User,
    val createdAt: Long,
    val replies: List<Message> = emptyList(),
    val reactions: List<String> = emptyList()
)