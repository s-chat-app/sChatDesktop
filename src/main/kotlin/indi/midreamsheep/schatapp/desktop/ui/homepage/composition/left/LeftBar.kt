package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.manager.server.Server
import indi.midreamsheep.schatapp.desktop.ui.util.image.AsyncImage
import indi.midreamsheep.schatapp.desktop.ui.util.image.loadImageBitmap

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun LeftBar(modifier: Modifier,
            manager: MutableState<GlobalManager>,
            update:(
                MutableState<GlobalManager>,
                Server
                    ) ->Unit
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //上边界
        Spacer(modifier = Modifier.height(8.dp))
        //个人头像
        OutlinedIconButton(onClick = {},
            shape = RoundedCornerShape(100),
            modifier = Modifier
                .size(47.dp)
                .border(1.dp, Color(232, 224, 228), RoundedCornerShape(100))
        ) {
            Image(painterResource("icon/none.png"),
                contentDescription = "Localized description",
                modifier = Modifier.fillMaxSize())
        }
        //中间空白
        Spacer(modifier = Modifier.height(25.dp))
        //服务器列表
        LazyColumn  (modifier = Modifier.weight(1f)){
            items(manager.value.serverList){
                serverItem(it,manager,update)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun serverItem(server: Server, manager: MutableState<GlobalManager>, update: (MutableState<GlobalManager>,Server) -> Unit){
    BadgedBox(
        badge = {
            Badge(
                modifier = Modifier.offset { IntOffset(-8, 12) },
                containerColor = Color(0xffFFB4AB)
            ) {
                val badgeNumber = "8"
                Text(
                    badgeNumber,
                    modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    },
                    color = Color(0xff690005),
                )
            }
        }) {
        OutlinedIconButton(
            onClick = {
                update(manager,server)
            },
            border = BorderStroke(if(server.serverMeta.id == manager.value.currentServer.serverMeta.id){2.dp}else{0.dp}, Color(0xFFFFFFFF)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(42.dp).width(42.dp)
        ) {
            AsyncImage(
                load = { loadImageBitmap(server.serverData.headPictureUrl) },
                painterFor = { remember { BitmapPainter(it) } },
                contentDescription = "Idea logo",
                modifier = Modifier.size(42.dp)
            )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}