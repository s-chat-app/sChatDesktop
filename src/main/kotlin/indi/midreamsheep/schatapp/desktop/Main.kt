package indi.midreamsheep.schatapp.desktop

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import indi.midreamsheep.schatapp.desktop.constant.Constants
import indi.midreamsheep.schatapp.desktop.ui.homepage.homePage
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme

@Composable
@Preview
fun App() {
    MaterialTheme (
        colors = MainTheme
    ){
        homePage()
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = WindowState(width = Constants.WINDOW_WIDTH.dp, height = Constants.WINDOW_HEIGHT.dp),
    ) {
        App()
    }
}
