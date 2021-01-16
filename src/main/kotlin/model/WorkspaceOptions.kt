package model

open class WorkspaceOption(
    val id: Int,
    val name: String,
    val image: String,
    val type: WorkspaceOptionType = WorkspaceOptionType.General
)

sealed class WorkspaceOptionType {
    object General : WorkspaceOptionType()
    object Channel : WorkspaceOptionType()
    object DirectMessage : WorkspaceOptionType()
}

data class DMOption(
    val user: User,
    val isOnline: Boolean? = null
) : WorkspaceOption(user.id, user.name, user.image, WorkspaceOptionType.DirectMessage)

data class ChannelOption(
    val _id: Int,
    val _name: String,
    val _image: String,
    val createdBy: User,
    val createdAt: Long
) : WorkspaceOption(_id, _name, _image, WorkspaceOptionType.Channel)

data class WorkspaceOptionUiModel(
    val general: List<WorkspaceOption>,
    val channels: List<WorkspaceOption>,
    val messages: List<WorkspaceOption>
)
