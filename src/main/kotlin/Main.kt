import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.local.resource.LocalResourceManager
import indi.midreamsheep.schatapp.desktop.ui.homepage.homePage
import indi.midreamsheep.schatapp.desktop.ui.loading.loadingPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun main() = application {
    var stateText by remember { mutableStateOf("nothing") }

    val isLoading: Boolean by produceState<Boolean>(true) {
        value = withContext(Dispatchers.IO) {
            stateText = "执行依赖注入中"
            val applicationContext = SChatApplicationContext.getApplicationContext()
            stateText = "正在读取配置文件"
            applicationContext.getBean(LocalResourceManager::class.java).loadAllConfig()
            false
        }
    }
    if (!isLoading){
        //获取配置文件
        val coreConfig = SChatApplicationContext.getApplicationContext()
            .getBean(LocalResourceManager::class.java).configManagerMap["core"]
        Window(
            onCloseRequest = ::exitApplication,
            state = WindowState(width = (coreConfig!!.get("window_width","1200")).toInt().dp, height = (coreConfig.get("window_height","800")).toInt().dp),
        ) {
            homePage()
        }
    } else {
        Window(
            onCloseRequest = ::exitApplication,
            state = WindowState(width = 500.dp, height = 500.dp),
        ) {
            loadingPage(stateText)
        }
    }
}