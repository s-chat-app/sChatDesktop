package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatList(modifier: Modifier) {
    Column(modifier, horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(8.dp))
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            //设置颜色
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xff4D444C),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            value = text,
            onValueChange = { text = it },
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { text = "" },
                    modifier = Modifier
                        .size(17.5.dp)
                ) {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = "menu",
                        tint = Color(0xffE8E0E4)
                    )
                }
            },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.onPreviewKeyEvent {
                when {
                    (it.key == Key.Enter && it.type == KeyEventType.KeyUp) -> {
                        text = ""
                        true
                    }
                    else -> false
                }
            }.size(width = 260.dp, height = 45.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            Modifier.weight(1f).verticalScroll(rememberScrollState())
        ){
            for (i in 1..10) {
                Row(
                    Modifier.padding(10.dp).clickable {
                    }
                ){
                    Image(
                        painterResource("icon/user.png"), contentDescription = "Avatar",
                        modifier = Modifier.size(35.dp)
                    )
                    Column(Modifier.padding(start = 10.dp)){
                        Text("chat_name", fontSize = 15.sp, color = Color(0xffE8E0E4))
                        Text("chat_info", fontSize = 10.sp, color = Color(0xffE8E0E4))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Column {
                        Text("chat_unread", fontSize = 10.sp, color = Color(0xffE8E0E4))
                        Text("chat_time", fontSize = 10.sp, color = Color(0xffE8E0E4))
                    }
                }
            }
        }
    }
}