import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import indi.midreamsheep.schatapp.desktop.constant.Constants
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListController
import indi.midreamsheep.schatapp.desktop.ui.homepage.homePage
import indi.midreamsheep.schatapp.desktop.ui.loading.loadingPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
@Preview
fun App() {
    var stateText by remember { mutableStateOf("nothing") }

    val isLoading: Boolean by produceState<Boolean>(true) {
        value = withContext(Dispatchers.IO) {
            stateText = "正在获取源本地配置文件"
            stateText = "执行依赖注入中"
            SChatApplicationContext.getApplicationContext()
            false
        }
    }
    if (!isLoading){
        homePage()
    } else {
        loadingPage(stateText)
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
