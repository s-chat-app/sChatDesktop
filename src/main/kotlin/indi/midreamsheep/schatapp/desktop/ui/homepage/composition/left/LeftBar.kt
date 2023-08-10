package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.manager.GlobalManager
import indi.midreamsheep.schatapp.desktop.manager.server.Server
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme
import indi.midreamsheep.schatapp.desktop.ui.util.image.AsyncImage
import indi.midreamsheep.schatapp.desktop.ui.util.image.loadImageBitmap
import indi.midreamsheep.schatapp.desktop.ui.util.image.loadSvgPainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun LeftBar(modifier: Modifier, manager: MutableState<GlobalManager>) {
    val density = LocalDensity.current
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(8.dp))
        //头像
        OutlinedIconButton(onClick = {},
                shape = RoundedCornerShape(100),
            modifier = Modifier.size(47.dp).border(1.dp, Color(232, 224, 228), RoundedCornerShape(100))
            ) {
            Image(painterResource("icon/none.png"), contentDescription = "Localized description",modifier = Modifier.fillMaxSize())
        }
        Spacer(modifier = Modifier.height(25.dp))
        //服务器列表
        Column (modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())){
            for (server in manager.value.serverList) {
                serverItem(server,density)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun serverItem(server: Server, density: Density){
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
            onClick = { },
            border = BorderStroke(1.dp, MainTheme.background),
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