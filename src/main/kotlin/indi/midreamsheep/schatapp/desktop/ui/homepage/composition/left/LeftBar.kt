package indi.midreamsheep.schatapp.desktop.ui.homepage.composition.left

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun LeftBar(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        IconButton(onClick = {}) {
            Icon(Icons.Outlined.Menu, contentDescription = "Localized description")
        }
        Column (modifier = Modifier.weight(19f).verticalScroll(rememberScrollState())){
            for (i in 1..10) {
                OutlinedButton(
                    onClick = { },
                    border = BorderStroke(1.dp, Color.Red),
                    shape = RoundedCornerShape(
                        topStartPercent = 100,
                        bottomStartPercent = 100,
                    ),
                    // or shape = CircleShape
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red),
                ) {
                    Text(text = "服务器$i", lineHeight = 2.sp)
                }
            }
        }
    }
}