package ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import extensions.formatCreatedDate
import theme.SlackColors

@Composable
fun DateDivider(dateInMillis: Long) {
    Row(
        modifier = Modifier.padding(
            vertical = 10.dp
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.weight(1f)
        )
        Box(
            modifier = Modifier
                .background(
                    color = SlackColors.black
                )
                .border(
                    width = 1.dp,
                    color = SlackColors.grey,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Text(
                text = dateInMillis.formatCreatedDate(),
                color = Color.White,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(horizontal = 15.dp, vertical = 5.dp)
            )
        }
        Divider(
            modifier = Modifier.weight(1f)
        )
    }
}