package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.manager.server.Server
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list.ChatList
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat.ChatWindow
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left.LeftBar

@Composable
@Preview
fun homePage(){
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        val manager = remember { mutableStateOf (GlobalManager.build()) }
        val currentServer = remember { mutableStateOf(manager.value.currentServer) }

        LeftBar(Modifier.weight(70f).background(MaterialTheme.colors.primary),manager){
            m,s ->
            GlobalManager.setCurrentServer(m,s)
            currentServer.value = s
        }

        ChatList(Modifier.weight(280f).background(MaterialTheme.colors.primary),currentServer){
            server,info->
            Server.setCurrentInfo(server,info)
        }

        ChatWindow(Modifier.weight(800f).background(MaterialTheme.colors.primary))
    }
}