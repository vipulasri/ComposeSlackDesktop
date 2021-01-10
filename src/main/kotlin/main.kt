import androidx.compose.desktop.Window
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import data.workspaces
import theme.DarkColorPalette
import theme.LightColorPalette
import theme.typography
import ui.SlackWorkSpacesBar
import ui.SlackWorkspaceInfoBar

fun main() = Window(
    title = "Slack Compose Desktop",
) {
    val darkTheme = savedInstanceState { true }
    MaterialTheme(
        colors = if (darkTheme.value) DarkColorPalette else LightColorPalette,
        typography = typography
    ) {
        SlackApp()
    }
}

@Composable
private fun SlackApp() {
    Row (
        modifier = Modifier.background(
            color = MaterialTheme.colors.surface
        ).fillMaxSize()
    ) {
        val selectedWorkspace = remember { mutableStateOf(workspaces.first()) }
        SlackWorkSpacesBar(
            workspaces,
            selectedWorkspace.value,
        ) {
            selectedWorkspace.value = it
        }
        SlackWorkspaceInfoBar(selectedWorkspace.value)

    }
}