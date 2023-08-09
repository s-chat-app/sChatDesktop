package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list.ChatList
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat.ChatWindow
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left.LeftBar

@Composable
@Preview
fun homePage(){
    MaterialTheme{
        Row(modifier = Modifier.fillMaxSize(),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        ) {
            LeftBar(Modifier.weight(1f))
            ChatList(Modifier.weight(4f))
            ChatWindow(Modifier.weight(15f))
        }
    }
}