package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import androidx.compose.runtime.Composable;
import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.channellist.ChannelListKt;
import kotlin.Unit;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Comment
@Data
public class ChannelListController {
    /**
     * 全局ChatChannel信息
     * */
    private Map<Long, ChatChannel> chatChannelMap = new HashMap<>();

    /**
     * 发送消
     * */
    @Injector
    private ChannelListControllerOE channelListControllerOE;


    public List<ChatChannel> getList() {
        return new ArrayList<>(chatChannelMap.values());
    }

}
