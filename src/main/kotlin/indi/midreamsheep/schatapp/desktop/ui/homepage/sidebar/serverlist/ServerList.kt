package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.serverlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun serverList() {
    Column(
        modifier =  Modifier.width(43.dp)
            .fillMaxHeight()
            .background(Color(161, 216, 255))
            .padding(horizontal = 4.dp)
    ) {
        serverItem("/icon/chi_tang.png")
        serverItem("/icon/none.png")
        serverItem("/icon/user.png")
    }
}

@Composable
fun serverItem(
    path:String
){
    Box(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .size(35.dp),
        contentAlignment = Alignment.Center,
    )
    {
        Image(
            painter = painterResource(path),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(35.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Text(
            text = "A",
            color = Color(255, 255, 255)
        )
    }
}