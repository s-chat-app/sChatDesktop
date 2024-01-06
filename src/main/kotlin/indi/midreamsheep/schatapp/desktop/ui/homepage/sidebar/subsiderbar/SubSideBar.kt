package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar

import androidx.compose.material.Text
import androidx.compose.runtime.*
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListController
import io.reactivex.schedulers.Schedulers

@OptIn(InternalComposeApi::class)
@Composable
fun selectList() {
    //建立状态监听
    var state by remember { mutableStateOf(SubSideBarFun {
        { Text(text = "nothing") }
    })}
    LaunchedEffect(Unit) {
        val controller = SChatApplicationContext.getApplicationContext().getBean(ChannelListController::class.java)
        controller.channelListControllerOE.chatChannelObservable
            .subscribeOn(Schedulers.io())
            .subscribe { newData ->
                state = newData
            }
    }
    state.getComposeFun()()
}