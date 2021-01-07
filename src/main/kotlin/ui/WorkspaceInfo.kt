package ui

import Icons
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.Workspace
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
        Row {
            Image(
                bitmap = imageFromResource(option.image),
                modifier = Modifier.preferredSize(15.dp),
                colorFilter = ColorFilter.tint(
                    color = Color.LightGray
                )
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                text = option.name,
                color = Color.LightGray,
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.Light
                )
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )
    }
}