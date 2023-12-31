package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.channellist.channelList
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.searchbox.chattyTopBar
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.serverlist.serverList

@Composable
fun sideBar(
    modifier: Modifier,
) {
    //侧边栏
    Column(modifier.width(368.dp).background(Color(245,250,255), shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 0.dp))
        .shadow(
            5.dp,
            spotColor = Color.LightGray)
        .padding(end = 5.dp)){
        Spacer(modifier = Modifier.height(1.dp))
        chattyTopBar()
        Spacer(modifier = Modifier.height(1.dp))
        Row(
            Modifier.width(368.dp)
        ) {

            var nowSelected by remember { mutableStateOf(3L) }
            serverList(nowSelected,
            ){
                //点击事件
                nowSelected = it
            }
            //联系人列表
            channelList(nowSelected)
        }
    }
}



