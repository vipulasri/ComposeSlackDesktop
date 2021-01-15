package ui

import Icons
import VerticalDivider
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import messageOptionsIcons
import model.ChannelOption
import model.DMOption
import model.WorkspaceOption
import model.WorkspaceOptionType
import richTextIcons
import theme.LatoFontBoldFamily
import theme.SlackColors

@Composable
fun SlackDetailsUi(option: WorkspaceOption) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(
                color = SlackColors.detailsBg
            )
    ) {
        DetailsHeader(option)
        Divider()
        Column(
            modifier = Modifier.weight(1f)
        ) {
            ContentUi(option)
        }
        ContentFooter(option)
        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
}

@Composable
private fun DetailsHeader(option: WorkspaceOption) {
    Row(
        modifier = Modifier.preferredHeight(70.dp)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HeaderStartIcon(option)
        Text(
            text = option.name,
            color = Color.White,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.Bold,
                fontFamily = LatoFontBoldFamily
            ),
            modifier = Modifier.weight(1f)
        )
        HeaderMenu(option)
    }
}

@Composable
private fun ContentUi(option: WorkspaceOption) {
    when (option.type) {
        is WorkspaceOptionType.General -> {

        }
        is WorkspaceOptionType.Channel -> {
            ChannelDetailsUi(option as ChannelOption)
        }
        is WorkspaceOptionType.DirectMessage -> {

        }
    }
}

@Composable
private fun ContentFooter(option: WorkspaceOption) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(
                color = SlackColors.black
            )
            .border(
                width = 1.dp,
                color = SlackColors.grey,
                shape = RoundedCornerShape(4.dp)
            ),
    ) {
        Text(
            text = "Message ${option.name}",
            color = SlackColors.grey,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(12.dp)
        )
        Divider()
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FooterIcon(
                modifier = Modifier.padding(horizontal = 4.dp),
                image = Icons.lightning
            )
            VerticalDivider(
                modifier = Modifier.height(25.dp)
            )

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                richTextIcons.forEach { icon ->
                    FooterIcon(image = icon)
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                messageOptionsIcons.forEach { icon ->
                    FooterIcon(image = icon)
                }
            }
        }
    }
}

@Composable
private fun HeaderStartIcon(option: WorkspaceOption) {
    when (option.type) {
        is WorkspaceOptionType.General -> {
            // do nothing
        }
        is WorkspaceOptionType.Channel -> {
            Text(
                text = "#",
                color = Color.White,
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = LatoFontBoldFamily
                )
            )
            Spacer(
                modifier = Modifier.width(2.dp)
            )
        }
        is WorkspaceOptionType.DirectMessage -> {
            (option as? DMOption)?.isOnline?.let { status ->
                if (status) OnlineStatusUi() else OfflineStatusUi()
                Spacer(
                    modifier = Modifier.width(6.dp)
                )
            }
        }
    }
}

@Composable
private fun HeaderMenu(option: WorkspaceOption) {
    when (option.type) {
        is WorkspaceOptionType.General -> {
            // do nothing
        }
        is WorkspaceOptionType.Channel -> {
            HeaderIcon(Icons.addPerson)
            Spacer(
                modifier = Modifier.width(10.dp)
            )
        }
        is WorkspaceOptionType.DirectMessage -> {
            HeaderIcon(Icons.call)
            Spacer(
                modifier = Modifier.width(10.dp)
            )
        }
    }
    HeaderIcon(Icons.info)
}

@Composable
private fun HeaderIcon(image: String) {
    Image(
        bitmap = imageFromResource(image),
        colorFilter = ColorFilter(SlackColors.grey, BlendMode.SrcIn),
        modifier = Modifier.preferredSize(20.dp)
    )
}

@Composable
private fun FooterIcon(
    modifier: Modifier = Modifier,
    image: String
) {
    Image(
        bitmap = imageFromResource(image),
        colorFilter = ColorFilter(SlackColors.grey, BlendMode.SrcIn),
        modifier = modifier
            .padding(horizontal = 6.dp, vertical = 15.dp)
            .preferredSize(16.dp)
    )
}

@Composable
private fun OnlineStatusUi() {
    Box(
        modifier = Modifier.background(
            color = SlackColors.onlineDark,
            shape = CircleShape
        ).preferredSize(10.dp)
    )
}

@Composable
private fun OfflineStatusUi() {
    Box(
        modifier = Modifier.border(
            width = 1.5.dp,
            color = SlackColors.grey,
            shape = CircleShape
        ).preferredSize(10.dp)
    )
}