package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.list

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.input.key.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import indi.midreamsheep.schatapp.desktop.manager.chat.SChatInfo
import indi.midreamsheep.schatapp.desktop.manager.server.Server
import indi.midreamsheep.schatapp.desktop.ui.util.image.AsyncImage
import indi.midreamsheep.schatapp.desktop.ui.util.image.loadImageBitmap

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ChatList(
    modifier: Modifier,
    currentServer: MutableState<Server>,
    update: (MutableState<Server>, SChatInfo) -> Unit
) {
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
            }.size(width = 260.dp, height = 45.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            Modifier.weight(1f)
        ) {
            items(currentServer.value.infos) {
                chatItem(it, currentServer, update)
            }
        }
    }
}

@Composable
fun chatItem(
    info: SChatInfo,
    server: MutableState<Server>,
    update: (MutableState<Server>, SChatInfo) -> Unit
) {
    val color = if (server.value.currentInfo.id != info.id) {
        MaterialTheme.colors.primary
    } else {
        Color(0xff524153)
    }

    Row(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(20))
            .background(color)
            .clickable {
                update(server, info)
            }
    ) {
        AsyncImage(
            load = { loadImageBitmap(info.headPictureUrl) },
            painterFor = { remember { BitmapPainter(it) } },
            contentDescription = "chat_avatar",
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(20))
        )
        Column(Modifier.padding(start = 10.dp)) {
            Text(
                info.name,
                fontSize = 18.sp,
                color = Color(0xffE8E0E4),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "chat_info",
                fontSize = 10.sp,
                color = Color(0xffE8E0E4)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {

            Text(
                "chat_unread",
                fontSize = 10.sp,
                color = Color(0xffE8E0E4),
                modifier = Modifier
                    .padding(5.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                "chat_time",
                fontSize = 10.sp,
                color = Color(0xffE8E0E4),
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}