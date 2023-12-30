package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.friendlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun friendList() {
    Column{
        friendItem("/icon/chi_tang.png")
        friendItem("/icon/none.png")
    }
}

@Composable
fun friendItem(
    path:String
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
                Image(painter = painterResource(path), contentDescription = null)
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                //昵称
                Column(
                    Modifier.weight(1f)
                ) {
                    //昵称
                    Text(text = "name", fontSize = 20.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    //最后一条消息
                    Text(text = "lastMessage", fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.width(4.dp))
                //时间
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = "${Random.nextInt(0, 24)}:${Random.nextInt(0, 60)}", fontSize = 10.sp)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "${Random.nextInt(0, 50)}", fontSize = 10.sp)
                }
            }
        }
    }
}