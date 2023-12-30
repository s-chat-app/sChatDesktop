package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.friendlist.friendList
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.searchbox.chattyTopBar
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.serverlist.serverList

@Composable
fun sideBar(
    modifier: Modifier
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
            serverList()
            //联系人列表
            friendList()
        }
    }
}



