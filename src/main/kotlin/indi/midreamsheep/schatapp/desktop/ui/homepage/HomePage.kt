package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.manager.chat.AbstractInfo
import indi.midreamsheep.schatapp.desktop.manager.server.Server
import indi.midreamsheep.schatapp.desktop.service.command.UpdateSignal
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list.ChatList
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat.ChatWindow
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left.LeftBar
import indi.midreamsheep.schatapp.frame.net.entity.pojo.Message
import io.reactivex.Observable
import java.util.SortedMap

@Composable
@Preview
fun homePage(
    globalManager: GlobalManager,
    create: Observable<UpdateSignal>
) {
    val manager = remember { mutableStateOf(globalManager) }
    val currentServer = remember { mutableStateOf(manager.value.currentServer) }
    val currentInfo = remember { mutableStateOf(currentServer.value.currentInfo) }
    val currentMessages = remember { mutableStateOf(currentInfo.value.messages) }
    page(manager, currentServer, currentInfo,currentMessages,create)
}

@Composable
fun page(
    manager: MutableState<GlobalManager>,
    currentServer: MutableState<Server>,
    currentInfo: MutableState<AbstractInfo>,
    currentMessages: MutableState<SortedMap<Long, Message>>,
    observable: Observable<UpdateSignal>
){
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        val produceState = produceState(initialValue = UpdateSignal.getInstance()) {
            observable.subscribe {
                value = UpdateSignal.getInstance(value)
            }
        }
        LeftBar(Modifier.weight(70f).background(MaterialTheme.colors.primary), manager) { m, s ->
            GlobalManager.setCurrentServer(m, s)
            currentServer.value = s
            currentInfo.value = s.currentInfo
            currentMessages.value = currentInfo.value.messages
        }

        ChatList(Modifier.weight(280f).background(MaterialTheme.colors.primary), currentServer) { server, info ->
            Server.setCurrentInfo(server, info)
            currentInfo.value = info
            currentMessages.value = currentInfo.value.messages
        }

        ChatWindow(Modifier.weight(800f).background(MaterialTheme.colors.primary), currentInfo,currentMessages,produceState)
    }
}