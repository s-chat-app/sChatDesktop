package indi.midreamsheep.schatapp.desktop.ui.homepage

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list.ChatList
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat.ChatWindow
import indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left.LeftBar

@Composable
@Preview
fun homePage(){
    Row(
        modifier = Modifier.fillMaxSize(),
    ) {
        LeftBar(Modifier.weight(70f).background(MaterialTheme.colors.primary))
        ChatList(Modifier.weight(280f).background(MaterialTheme.colors.primary))
        ChatWindow(Modifier.weight(800f).background(MaterialTheme.colors.primary))
    }
}