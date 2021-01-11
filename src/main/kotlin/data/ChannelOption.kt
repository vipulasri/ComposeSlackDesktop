package data

data class ChannelOption(
    val _id: Int,
    val _name: String,
    val _image: String
) : WorkspaceOption(_id, _name, _image, WorkspaceOptionType.Channel)

val channels = listOf(
    ChannelOption(
        1,
        "announcements",
        Icons.hash
    ),
    ChannelOption(
        2,
        "intro",
        Icons.hash
    ),
    ChannelOption(
        3,
        "general",
        Icons.hash
    ),
    ChannelOption(
        4,
        "help",
        Icons.hash
    ),
    ChannelOption(
        5,
        "random",
        Icons.hash
    )
)