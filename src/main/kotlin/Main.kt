import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import indi.midreamsheep.schatapp.desktop.constant.Constants
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.navigation.Navigation
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme

val navigation = Navigation()
var nowPage:String = "LOADING"

@Composable
@Preview
fun App() {

}

fun main() = application {
        Window(
            onCloseRequest = ::exitApplication,
            state = WindowState(width = Constants.WINDOW_WIDTH.dp, height = Constants.WINDOW_HEIGHT.dp),
        ) {
            App()
        }
}
