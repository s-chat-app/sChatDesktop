import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import indi.midreamsheep.schatapp.desktop.constant.Constants
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.service.update.UpdateSignal
import indi.midreamsheep.schatapp.desktop.ui.homepage.homePage
import indi.midreamsheep.schatapp.desktop.ui.loading.Loading
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
@Preview
fun App(value: GlobalManager, create: Observable<UpdateSignal>) {
    MaterialTheme (
        colors = MainTheme
    ){
        homePage(value,create)
    }
}

fun main() = application {
    //创建流
    var emitter: ObservableEmitter<UpdateSignal>? = null
    val create = Observable.create { emitter = it }

    val globalManagerState = produceState(initialValue = GlobalManager.RECOMPOSE, producer = {
        //用协程加载
        value =  withContext(Dispatchers.IO) {
            Thread.sleep(1000)
            GlobalManager.build(emitter)
        }
    })

    if(globalManagerState.value == GlobalManager.RECOMPOSE){
        Window(
            onCloseRequest = ::exitApplication,
            state = WindowState(width = Constants.LOANING_WIDTH.dp, height = Constants.LOANING_HEIGHT.dp),
        ){
            Loading()
        }

    }else {
        Window(
            onCloseRequest = ::exitApplication,
            state = WindowState(width = Constants.WINDOW_WIDTH.dp, height = Constants.WINDOW_HEIGHT.dp),
        ) {
            App(globalManagerState.value, create)
        }
    }
}
