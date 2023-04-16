import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.navigationGraph

import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ui.theme.AppTheme
import java.awt.Dimension

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    AppTheme() {
        Window(
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(
                width = 1000.dp,
                height = 600.dp,
                position = WindowPosition.Aligned(Alignment.Center)
            )
        ) {
            window.minimumSize = Dimension(1000,500)
            setNavigationContent(ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration(), onApplicationFinish = {
                exitApplication()
            }) {
                navigationGraph()
            }
        }
    }
}
