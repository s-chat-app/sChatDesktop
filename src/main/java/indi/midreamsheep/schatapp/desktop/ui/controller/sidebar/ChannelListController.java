package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
