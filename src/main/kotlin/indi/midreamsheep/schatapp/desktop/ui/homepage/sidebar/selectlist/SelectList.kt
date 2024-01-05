package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListController
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListControllerFun
import io.reactivex.BackpressureStrategy
import kotlinx.coroutines.reactive.asFlow

@Composable
fun selectList() {
    //建立状态监听
    val controller = SChatApplicationContext.getApplicationContext().getBean(ChannelListController::class.java)
    val state by controller.channelListControllerOE.chatChannelObservable.toFlowable(
        BackpressureStrategy.BUFFER
    ).asFlow().collectAsState(
        initial = ChannelListControllerFun {
            listOf()
        }
    )
    val list = state.change()
    print(list.size)
    LazyColumn {
        items(list.size){
            list[it].getComposeFun()()
        }
    }
}