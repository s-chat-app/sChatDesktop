package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.entity.account.chat.server.ServerHandler
import indi.midreamsheep.schatapp.desktop.data.runtime.variable.GlobalInfo
import indi.midreamsheep.schatapp.desktop.ui.homepage.chatpage.chatPage
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.sideBar

@Composable
fun homePage(){
    Row {
        val context = SChatApplicationContext.getApplicationContext()

        val serverHandler = context.getBean(ServerHandler::class.java)
        val globalInfo = context.getBean(GlobalInfo::class.java)

        var nowSelectedServer by remember { mutableStateOf(globalInfo.selectedServerId.get()) }

        sideBar(Modifier.weight(1f),nowSelectedServer){
            nowSelectedServer = it
            //更新全局选中频道
            globalInfo.selectedServerId.set(it)
            globalInfo.selectedChannelId.set( serverHandler.getChannel(it).channelManger.channels[0].channelId)
        }
        //聊天页
        chatPage(
            Modifier.weight(3f)
        )
    }
}