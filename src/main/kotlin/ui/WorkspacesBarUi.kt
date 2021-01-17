package ui

import Icons
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.unit.dp
import model.Workspace
import theme.SlackColors
import theme.divider

@Composable
fun SlackWorkSpacesBar(
    workspaces: List<Workspace>,
    selectedWorkspace: Workspace,
    onWorkspaceSelected: (workspace: Workspace) -> Unit
) {
    LazyColumnFor(
        items = workspaces,
        modifier = Modifier
            .width(60.dp)
            .background(
                color = MaterialTheme.colors.surface,
                shape = RectangleShape
            )
            .border(
                border = BorderStroke(1.dp, color = divider),
                shape = RectangleShape
            )
            .fillMaxHeight(),
        contentPadding = PaddingValues(top = 15.dp, bottom = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) { workspace ->
        // border width change will not work, as internally 0.dp it defaults to 1.dp
        val borderColor = if (selectedWorkspace.id == workspace.id) Color.White else Color.Transparent
        Box(
            modifier = Modifier
                .border(
                    border = BorderStroke(2.5.dp, color = borderColor),
                    shape = RoundedCornerShape(30)
                )
        ) {
            Image(
                modifier = Modifier
                    .preferredSize(42.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(20))
                    .clickable {
                        onWorkspaceSelected.invoke(workspace)
                    },
                bitmap = imageFromResource(workspace.image)
            )
        }
        Spacer(
            modifier = Modifier.height(10.dp)
        )

        if (workspace == workspaces.last()) {
            Image(
                modifier = Modifier
                    .preferredSize(34.dp)
                    .padding(6.dp),
                bitmap = imageFromResource(Icons.add),
                colorFilter = ColorFilter.tint(SlackColors.grey)
            )
        }

    }
}