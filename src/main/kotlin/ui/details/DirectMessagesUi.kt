package ui.details

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.MessagesRepository
import extensions.compareDates
import model.DMOption
import theme.LatoFontBoldFamily
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
    Text(
        text = "# ${dm.user.name}",
        color = Color.White,
        style = MaterialTheme.typography.h4.copy(
            fontFamily = LatoFontBoldFamily
        ),
        modifier = Modifier.padding(horizontal = 20.dp)
    )
    Spacer(
        modifier = Modifier.height(10.dp)
    )
    Text(
        text = "@${dm.user.username} created this channel on. " +
                "This is the very beginning of the #${dm.user.name} channel.",
        color = Color.White,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(horizontal = 20.dp)
    )
    Spacer(
        modifier = Modifier.height(20.dp)
    )
}