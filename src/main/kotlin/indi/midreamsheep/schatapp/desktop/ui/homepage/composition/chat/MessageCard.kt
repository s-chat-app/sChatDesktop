package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import indi.midreamsheep.schatapp.frame.net.entity.pojo.Message

@Composable
fun messageCard(message: Message) {
    Row(Modifier.padding(8.dp).height((message.message.split("\n").size * 30 + 4 + 4).dp).fillMaxWidth()){
        Image(
            //TODO 通过messageFrom获取头像
            painter = painterResource("icon/user_send.png"),
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp)
                .size(40.dp)

        )
        Column(modifier = Modifier.clickable {  }) {
            Text(
                text = "chitang",
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                //TODO 根据消息函数设置高度
                modifier = Modifier.height((message.message.split("\n").size * 20).dp),
            ) {
                Text(
                    //TODO 目前只实现基本的文字
                    text = message.message,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = Int.MAX_VALUE,
                    style = MaterialTheme.typography.body2,
                    fontSize = 14.sp
                )
            }
        }
    }
}