package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import indi.midreamsheep.schatapp.desktop.ui.theme.MainTheme

@Composable
@Preview
fun LeftBar(modifier: Modifier) {

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
            for (i in 1..10) {
                OutlinedIconButton(
                    onClick = { },
                    border = BorderStroke(1.dp, MainTheme.background),
                    shape = RoundedCornerShape(25),
                    modifier = Modifier.height(42.dp).width(42.dp)
                ) {
                    Image(
                        painterResource("icon/chi_tang.png"), contentDescription = "Localized description"
                        ,modifier = Modifier.size(42.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}