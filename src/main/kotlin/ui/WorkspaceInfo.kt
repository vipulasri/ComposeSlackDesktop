package ui

import Icons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.Workspace
import data.WorkspaceOption
import data.options
import theme.divider

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
        Row(
            modifier = Modifier.padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = workspace.name,
                color = Color.White
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
        Divider(color = divider)
        InfoOptions()
    }
}

@Composable
private fun InfoOptions() {
    LazyColumnFor(
        items = options,
        modifier = Modifier.padding(15.dp),
    ) { option ->
        Option(option)
        Spacer(
            modifier = Modifier.height(10.dp)
        )
    }
}

@Composable
private fun Option(option: WorkspaceOption) {
    val isItemsExpanded = remember { mutableStateOf(false) }
    Column {

        val iconImage = if (option.channels.isNotEmpty()) {
            if (isItemsExpanded.value) Icons.caretUp else Icons.caretDown
        } else option.image

        IconAndTextView(
            modifier = Modifier
                .clickable(indication = null) {
                    if (option.channels.isNotEmpty()) {
                        isItemsExpanded.value = !isItemsExpanded.value
                    }
                },
            image = iconImage,
            name = option.name
        )

        if (isItemsExpanded.value) {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            option.channels.forEach { channel ->
                IconAndTextView(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    image = channel.image,
                    name = channel.name
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }
        }
    }
}

@Composable
private fun IconAndTextView(
    modifier: Modifier = Modifier,
    image: String,
    name: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            bitmap = imageFromResource(image),
            modifier = Modifier.preferredSize(15.dp),
            colorFilter = ColorFilter.tint(
                color = Color.LightGray
            )
        )
        Spacer(
            modifier = Modifier.width(10.dp)
        )
        Text(
            text = name,
            color = Color.LightGray,
            style = MaterialTheme.typography.body2.copy(
                fontWeight = FontWeight.Light
            )
        )
    }
}