package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.selectitems.channelitem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.subsiderbar.selectitems.SelectListItem
import indi.midreamsheep.schatapp.desktop.ui.util.image.AsyncImage
import java.util.*

class ChannelItem(private val channel:ChatChannel) : SelectListItem {

    override fun getComposeFun(): @Composable () -> Unit {
        return  { channelItem(channel) }
    }

    @Composable
    fun channelItem(
        channel: ChatChannel
    ){
        Surface(
            modifier = Modifier.fillMaxWidth().height(55.dp).clickable {
                //点击事件
            }
        ) {
            Column {
                Row(
                    modifier = Modifier.background(Color(245, 250, 255)).padding(vertical = 5.dp, horizontal = 5.dp)
                ) {
                    //头像
                    AsyncImage(
                        id = channel.avatar,
                        contentDescription = "",
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    //昵称
                    Column(
                        Modifier.weight(1f)
                    ) {
                        //昵称
                        Text(text = channel.name, fontSize = 20.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        //最后一条消息
                        Text(text = channel.lastMessage, fontSize = 10.sp)
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    //时间
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        //对时间进行处理，转为 小时:分钟
                        val date = Date(channel.lastMessageTime)
                        Text(text = ""+date.hours+":"+date.minutes, fontSize = 10.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Text(text = ""+channel.unreadMessageCount, fontSize = 10.sp)
                    }
                }
            }
        }
    }

}