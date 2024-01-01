package indi.midreamsheep.schatapp.desktop.ui.loading

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import indi.midreamsheep.schatapp.desktop.context.SChatApplicationContext
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListController
import indi.midreamsheep.schatapp.desktop.ui.controller.sidebar.ChannelListControllerFun
import io.reactivex.BackpressureStrategy
import kotlinx.coroutines.reactive.asFlow

@Composable
fun loadingPage(
    state:String
) {
    Text("State:$state")
}