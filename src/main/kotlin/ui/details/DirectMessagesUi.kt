package ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import data.MessagesRepository
import extensions.compareDates
import model.DMOption
import model.currentUser
import model.slackbotUser
import theme.LatoFontBoldFamily
import theme.SlackColors
import ui.common.DateDivider

@Composable
fun DirectMessagesUi(dm: DMOption) {
    ScrollableColumn {
        DMDetailsHeader(dm)
        val messages = MessagesRepository.getMessages(dm.user)
        messages.forEachIndexed { index, message ->
            if (index == 0 ||
                (compareDates(messages[index.minus(1)].createdAt, message.createdAt))
            ) {
                DateDivider(message.createdAt)
            }
            MessageUi(message)
        }
    }
}

@Composable
private fun DMDetailsHeader(dm: DMOption) {
    Spacer(
        modifier = Modifier.height(20.dp)
    )
    Row(
        Modifier.padding(horizontal = 20.dp)
    ) {
        Image(
            bitmap = imageFromResource(dm.user.image),
            modifier = Modifier.preferredSize(50.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Column {
            Text(
                text = dm.user.name,
                color = Color.White,
                style = MaterialTheme.typography.body2.copy(
                    fontFamily = LatoFontBoldFamily
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Text(
                text = dm.user.username,
                color = Color.Gray,
                style = MaterialTheme.typography.body2.copy(
                    fontFamily = LatoFontBoldFamily
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }
    Spacer(
        modifier = Modifier.height(20.dp)
    )
    SubtitleText(dm)
    Spacer(
        modifier = Modifier.height(20.dp)
    )
}

@Composable
private fun SubtitleText(dm: DMOption) {
    val text = when (dm.user) {
        slackbotUser -> {
            buildAnnotatedString {
                append("I, however, am not a human. Just a bot (a simple bot, with only a few tricks up my metaphorical sleeve). But I’m still happy you’re here!")
            }
        }
        currentUser -> {
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontFamily = LatoFontBoldFamily
                    )
                ) {
                    append("This is your space. ")
                }
                append("Draft messages, list your to-dos, or keep links and files handy. You can also talk to yourself here, but please bear in mind you’ll have to supply both sides of the conversation.")
            }
        }
        else -> {
            buildAnnotatedString {
                append("This is the very beginning of your direct message history with ")
                withStyle(
                    SpanStyle(
                        color = SlackColors.link,
                        background = SlackColors.linkBg
                    )
                ) {
                    append("@${dm.user.username}")
                }
            }
        }
    }

    Text(
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(horizontal = 20.dp)
    )
}