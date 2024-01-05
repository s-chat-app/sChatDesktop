package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.serverlist

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.entity.account.chat.server.ServerHandler
import indi.midreamsheep.schatapp.desktop.entity.account.chat.server.ChatServer
import indi.midreamsheep.schatapp.desktop.ui.util.image.AsyncImage

@Composable
fun serverList(
    nowSelected: Long,
    selectRecall: (Long) -> Unit
) {

    val listState = rememberLazyListState()
    val channels = SChatApplicationContext.getApplicationContext().getBean(ServerHandler::class.java).channels

    LazyColumn(
        modifier =  Modifier.width(43.dp)
            .fillMaxHeight()
            .background(Color(161, 216, 255))
            .padding(horizontal = 4.dp),
        state = listState,
    ) {
        items(channels.size){
            serverItem(
                channels[it],
                nowSelected,
                selectRecall
            )
        }
    }
}

@Composable
fun serverItem(
    channel: ChatServer,
    nowSelected: Long,
    selectRecall: (Long) -> Unit
){
    Box(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .size(35.dp)
            .clickable {
                selectRecall(channel.serverId)
            }
        ,
        contentAlignment = Alignment.Center,
    )
    {
        AsyncImage(
            id = channel.avatar,
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(
                    width = 1.dp,
                    color = if (channel.serverId == nowSelected) Color.White else Color.Transparent,
                    shape = RoundedCornerShape(5.dp)
                ),
        )
        Text(
            text = "A",
            color = Color(255, 255, 255)
        )
    }
}