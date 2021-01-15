package ui.common

import Icons
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
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
        Row(
            modifier = Modifier
                .background(
                    color = SlackColors.black
                )
                .border(
                    width = 1.dp,
                    color = SlackColors.grey,
                    shape = RoundedCornerShape(12.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = dateInMillis.formatCreatedDate(),
                color = Color.White,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 15.dp, top = 5.dp, bottom = 5.dp)
            )
            Image(
                bitmap = imageFromResource(Icons.arrowDown),
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp, bottom = 5.dp, end = 15.dp)
                    .preferredSize(5.dp),
                colorFilter = ColorFilter(Color.White, BlendMode.SrcIn),
            )
        }
        Divider(
            modifier = Modifier.weight(1f)
        )
    }
}