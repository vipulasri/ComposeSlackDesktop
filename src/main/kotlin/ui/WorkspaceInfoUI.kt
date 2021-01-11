package ui

import Icons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
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
import data.WorkspaceOptionsRepository
import model.*
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
        Spacer(
            modifier = Modifier.height(10.dp)
        )
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
    val options = WorkspaceOptionsRepository.options
    val selectedOption = remember { mutableStateOf(options.general.first()) }
    ScrollableColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        GeneralOptionGroup(
            options.general,
            selectedOption.value,
            onOptionClicked = {
                selectedOption.value = it
            }
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        DropDownOptionGroup(
            "Channels",
            options.channels,
            selectedOption.value,
            onOptionClicked = {
                selectedOption.value = it
            }
        )
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        DropDownOptionGroup(
            "Direct messages",
            options.messages,
            selectedOption.value,
            onOptionClicked = {
                selectedOption.value = it
            }
        )
    }
}

@Composable
private fun GeneralOptionGroup(
    options: List<WorkspaceOption>,
    selectedOption: WorkspaceOption,
    onOptionClicked: (option: WorkspaceOption) -> Unit
) {
    options.forEach { option ->
        GeneralOption(option, selectedOption, onOptionClicked = {
            onOptionClicked.invoke(it)
        })
    }
}

@Composable
private fun GeneralOption(
    option: WorkspaceOption,
    selectedOption: WorkspaceOption,
    onOptionClicked: (option: WorkspaceOption) -> Unit
) {
    val backgroundColor = if (selectedOption == option) optionSelected else Color.Transparent
    IconAndTextView(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor
            )
            .clickable(indication = null) {
                onOptionClicked.invoke(option)
            },
        image = option.image,
        name = option.name,
        isSelected = selectedOption == option
    )
}

@Composable
private fun DropDownOptionGroup(
    groupName: String,
    options: List<WorkspaceOption>,
    selectedOption: WorkspaceOption,
    onOptionClicked: (option: WorkspaceOption) -> Unit
) {
    val itemsExpanded = remember { mutableStateOf(true) }
    val icon = if (itemsExpanded.value) Icons.caretDown else Icons.caretRight
    IconAndTextView(
        modifier = Modifier.fillMaxWidth()
            .clickable(indication = null) {
                itemsExpanded.value = !itemsExpanded.value
            },
        image = icon,
        name = groupName
    )

    if (itemsExpanded.value) {
        options.forEach { option ->
            val backgroundColor = if (selectedOption == option) optionSelected else Color.Transparent
            when (option.type) {
                is WorkspaceOptionType.General -> {
                }
                is WorkspaceOptionType.Channel -> {
                    ChannelOption(
                        option as ChannelOption,
                        backgroundColor,
                        selectedOption,
                        onOptionClicked
                    )
                }
                is WorkspaceOptionType.DirectMessage -> {
                    DirectMessageOption(
                        option as DMOption,
                        backgroundColor,
                        selectedOption,
                        onOptionClicked
                    )
                }
            }
        }
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
            modifier = Modifier.preferredSize(16.dp),
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
private fun ChannelOption(
    channel: ChannelOption,
    backgroundColor: Color,
    selectedOption: WorkspaceOption,
    onOptionClicked: (option: WorkspaceOption) -> Unit
) {
    IconAndTextView(
        modifier = Modifier
            .background(
                color = backgroundColor
            )
            .fillMaxWidth()
            .clickable {
                onOptionClicked.invoke(channel)
            },
        horizontalPadding = 15.dp,
        image = channel.image,
        name = channel.name,
        isSelected = selectedOption == channel
    )
}

@Composable
private fun DirectMessageOption(
    message: DMOption,
    backgroundColor: Color,
    selectedOption: WorkspaceOption,
    onOptionClicked: (option: WorkspaceOption) -> Unit
) {
    DirectMessageView(
        modifier = Modifier
            .background(
                color = backgroundColor
            )
            .fillMaxWidth()
            .clickable {
                onOptionClicked.invoke(message)
            },
        dmOption = message,
        isSelected = selectedOption == message
    )
}

@Composable
private fun DirectMessageView(
    modifier: Modifier = Modifier,
    dmOption: DMOption,
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
                bitmap = imageFromResource(dmOption.image),
                modifier = Modifier.preferredSize(20.dp)
                    .clip(
                        dmOption.isOnline?.let {
                            ImageOnlineShape(8.dp)
                        } ?: RoundedCornerShape(4.dp)
                    ),
            )
            OnlineStatus(dmOption.isOnline)
        }
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Text(
            text = dmOption.name,
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