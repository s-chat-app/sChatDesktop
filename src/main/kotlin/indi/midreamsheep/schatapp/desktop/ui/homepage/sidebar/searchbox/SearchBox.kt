package indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.searchbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.LeadingIconTab
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun chattyTopBar(){
    //保持搜索栏内容
    val searchState = remember { mutableStateOf("") }
    //输入框
    BasicTextField(
        value = searchState.value,
        onValueChange = {
            searchState.value = it
        },

        modifier = Modifier.fillMaxWidth().height(40.dp).clip(RoundedCornerShape(4.dp,4.dp,4.dp,4.dp)).background(Color(199, 232, 255)),
        decorationBox = { innerTextField ->
            Row (
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                )
                Box(Modifier.fillMaxWidth()){
                    innerTextField()
                    if (searchState.value.isEmpty()){
                        androidx.compose.material.Text(
                            text = "Search",
                            style = MaterialTheme.typography.body1,
                            color = Color(197, 197, 197)
                        )
                    }
                }

            }
        }
    )
}