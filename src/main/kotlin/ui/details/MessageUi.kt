package ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.dp
import extensions.formatTime
import model.Message
import theme.LatoFontBoldFamily
import theme.SlackColors

@Composable
fun MessageUi(message: Message) {
    Row(
        modifier = Modifier.padding(
            horizontal = 20.dp,
            vertical = 5.dp
        )
    ) {
        Image(
            bitmap = imageFromResource(message.author.image),
            modifier = Modifier.preferredSize(35.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = message.author.name,
                    color = Color.White,
                    style = MaterialTheme.typography.body2.copy(
                        fontFamily = LatoFontBoldFamily
                    )
                )
                Spacer(
                    modifier = Modifier.width(10.dp)
                )
                Text(
                    text = message.createdAt.formatTime(),
                    color = SlackColors.grey,
                    style = MaterialTheme.typography.caption
                )
            }
            Spacer(
                modifier = Modifier.height(2.dp)
            )
            Text(
                message.content,
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
            Spacer(
                modifier = Modifier.height(4.dp)
            )
            Reactions(message.reactions)
        }
    }
}

@Composable
private fun Reactions(reactions: List<String>) {
    val distinctReactions = reactions.distinct()
    Row {
        distinctReactions.forEach { reaction ->
            ReactionUi(
                reaction,
                reactions.count { it == reaction }
            )
            Spacer(
                modifier = Modifier.width(6.dp)
            )
        }
    }
}

@Composable
private fun ReactionUi(
    reaction: String,
    count: Int
) {
    Row(
        modifier = Modifier
            .background(
                color = SlackColors.reactionBg,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = reaction,
            style = MaterialTheme.typography.body1,
        )
        Spacer(
            modifier = Modifier.width(4.dp)
        )
        Text(
            text = count.toString(),
            color = Color.White,
            style = MaterialTheme.typography.overline,
        )
    }
}