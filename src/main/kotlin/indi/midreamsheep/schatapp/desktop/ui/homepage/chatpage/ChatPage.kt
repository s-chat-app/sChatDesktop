package indi.midreamsheep.schatapp.desktop.ui.homepage.chatpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun chatPage(modifier: Modifier) {
    Column(
        modifier
    ) {
        //顶栏
        topBar()
        //聊天框
        chatBox()
        //输入框
        //inputBox()
    }

}

@Composable
fun topBar() {
    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(Color(161, 216, 255))
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp
                ),
        horizontalArrangement =  Arrangement.Center,
    ) {
        Column {
            Text(
                text = "Name",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Status",
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box (
            Modifier.fillMaxHeight(),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun chatBox(){
    Column(
        //左方添加阴影
        modifier = Modifier
            .fillMaxSize()
            .background(Color(229, 229, 229))
            .shadow(
                1.dp,
                ambientColor = Color.Gray,
                spotColor = Color.White
            )
            .padding(8.dp)

    ) {
        Message(
            onAuthorClick = {},
            msg = "hello                ",
            isUserMe = true,
            isLastMsg = true
        )
        Message(
            onAuthorClick = {},
            msg = "helsadddddddlo",
            isUserMe = true,
            isLastMsg = false
        )
        Message(
            onAuthorClick = {},
            msg = "helsadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddlo",
            isUserMe = true,
            isLastMsg = false
        )
        Message(
            onAuthorClick = {},
            msg = "hello                ",
            isUserMe = true,
            isLastMsg = true
        )
        Message(
            onAuthorClick = {},
            msg = "helsadddddddlo",
            isUserMe = true,
            isLastMsg = false
        )
        Message(
            onAuthorClick = {},
            msg = "helsadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddlo",
            isUserMe = true,
            isLastMsg = false
        )
    }
}