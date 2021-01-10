package ui

import Icons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.*
import theme.LatoFontBoldFamily
import theme.divider
import theme.optionSelected

@Composable
fun SlackWorkspaceInfoBar(workspace: Workspace) {
    Column(
        modifier = Modifier
            .preferredWidth(250.dp)
            .background(
                color = MaterialTheme.colors.surface,
                shape = RectangleShape
            )
            .border(
                border = BorderStroke(1.dp, color = divider),
                shape = RectangleShape
            )
            .fillMaxHeight()
    ) {
        InfoHeader(workspace)
        Divider(color = divider)
        InfoOptions()
    }
}

@Composable
private fun InfoHeader(workspace: Workspace) {
    Row(
        modifier = Modifier.padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = workspace.name,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = LatoFontBoldFamily
            )
        )
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Image(
            bitmap = imageFromResource(Icons.arrowDown),
            modifier = Modifier.preferredSize(8.dp),
            colorFilter = ColorFilter.tint(
                color = Color.White
            )
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier.preferredSize(35.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                bitmap = imageFromResource(Icons.edit),
                modifier = Modifier.preferredSize(15.dp),
                colorFilter = ColorFilter.tint(
                    color = Color.Black
                )
            )
        }
    }
}

@Composable
private fun InfoOptions() {
    val selectedOption = remember { mutableStateOf(options.first().name) }
    LazyColumnFor(
        items = options,
        modifier = Modifier.fillMaxWidth(),
    ) { option ->
        Option(option, selectedOption.value, onOptionClicked = {
            selectedOption.value = it
        })
    }
}

@Composable
private fun Option(
    option: WorkspaceOption,
    selectedOptionName: String,
    onOptionClicked: (optionName: String) -> Unit
) {
    val optionWithItems = option.type != WorkspaceOptionType.General
    val itemsExpanded = remember { mutableStateOf(optionWithItems) }
    Column {

        val iconImage = if (optionWithItems) {
            if (itemsExpanded.value) Icons.caretUp else Icons.caretDown
        } else option.image

        val backgroundColor = if (selectedOptionName == option.name) optionSelected else Color.Transparent

        IconAndTextView(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = backgroundColor
                )
                .clickable(indication = null) {
                    if (optionWithItems) {
                        itemsExpanded.value = !itemsExpanded.value
                    } else {
                        onOptionClicked.invoke(option.name)
                    }
                },
            image = iconImage,
            name = option.name,
            isSelected = selectedOptionName == option.name
        )

        if (itemsExpanded.value) {
            when (option.type) {
                is WorkspaceOptionType.General -> {
                    // do nothing
                }
                is WorkspaceOptionType.Channel -> {
                    ShowChannels(option.type.items, selectedOptionName, onOptionClicked)
                }
                is WorkspaceOptionType.DirectMessage -> {
                    ShowDirectMessages(option.type.items, selectedOptionName, onOptionClicked)
                }
            }
        }
    }
}

@Composable
private fun ShowChannels(
    channels: List<Channel>,
    selectedOptionName: String,
    onOptionClicked: (optionName: String) -> Unit
) {
    channels.forEach { channel ->
        val backgroundColor = if (selectedOptionName == channel.name) optionSelected else Color.Transparent

        IconAndTextView(
            modifier = Modifier
                .background(
                    color = backgroundColor
                )
                .fillMaxWidth()
                .clickable {
                    onOptionClicked.invoke(channel.name)
                },
            horizontalPadding = 15.dp,
            image = channel.image,
            name = channel.name,
            isSelected = selectedOptionName == channel.name
        )
    }
}

@Composable
private fun ShowDirectMessages(
    messages: List<DirectMessage>,
    selectedOptionName: String,
    onOptionClicked: (optionName: String) -> Unit
) {
    messages.forEach { message ->
        val backgroundColor = if (selectedOptionName == message.name) optionSelected else Color.Transparent
        DirectMessageView(
            modifier = Modifier
                .background(
                    color = backgroundColor
                )
                .fillMaxWidth()
                .clickable {
                    onOptionClicked.invoke(message.name)
                },
            directMessage = message,
            isSelected = selectedOptionName == message.name
        )
    }
}

@Composable
private fun IconAndTextView(
    modifier: Modifier = Modifier,
    horizontalPadding: Dp = 0.dp,
    image: String,
    name: String,
    isSelected: Boolean = false
) {
    val color = if (isSelected) Color.White else Color.LightGray
    Row(
        modifier = modifier
            .padding(horizontal = horizontalPadding + 15.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            bitmap = imageFromResource(image),
            modifier = Modifier.preferredSize(15.dp),
            colorFilter = ColorFilter.tint(
                color = color
            )
        )
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Text(
            text = name,
            color = color,
            style = MaterialTheme.typography.body2.copy(
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
private fun DirectMessageView(
    modifier: Modifier = Modifier,
    directMessage: DirectMessage,
    isSelected: Boolean = false
) {
    val color = if (isSelected) Color.White else Color.LightGray
    Row(
        modifier = modifier
            .padding(horizontal = 25.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                bitmap = imageFromResource(directMessage.image),
                modifier = Modifier.preferredSize(20.dp)
                    .clip(
                        directMessage.isOnline?.let {
                            ImageOnlineShape(8.dp)
                        } ?: RoundedCornerShape(4.dp)
                    ),
            )
            OnlineStatus(directMessage.isOnline)
        }
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Text(
            text = directMessage.name,
            color = color,
            style = MaterialTheme.typography.body2.copy(
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
private fun BoxScope.OnlineStatus(online: Boolean?) {
    online?.let { status ->
        if (status) OnlineStatusUi() else OfflineStatusUi()
    }
}

@Composable
private fun BoxScope.OnlineStatusUi() {
    Box(
        modifier = Modifier.background(
            color = Color.Green,
            shape = CircleShape
        ).preferredSize(6.dp).align(Alignment.BottomEnd)
    )
}

@Composable
private fun BoxScope.OfflineStatusUi() {
    Box(
        modifier = Modifier.border(
            width = 1.dp,
            color = Color.Gray,
            shape = CircleShape
        ).preferredSize(6.dp).align(Alignment.BottomEnd)
    )
}