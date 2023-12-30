package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import indi.midreamsheep.schatapp.desktop.ui.homepage.chatpage.chatPage
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.sideBar

@Composable
fun homePage(){
    Row {
        //侧边栏
        sideBar(Modifier.weight(1f))
        //聊天页
        chatPage(Modifier.weight(3f))
    }
}