package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import indi.midreamsheep.schatapp.desktop.data.runtime.variable.GlobalInfo;
import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist.SelectListItem;
import indi.midreamsheep.schatapp.desktop.ui.homepage.sidebar.selectlist.selectitems.channelitem.ChannelItem;
import io.reactivex.ObservableEmitter;
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
     * 显示的ChatChannel信息
     * */
    private Map<Long, SelectListItem> selectListItemMap = new HashMap<>();
    /**
     * 发送消
     * */
    @Injector
    private ChannelListControllerOE channelListControllerOE;
    /**
     * 全局变量
     * */
    @Injector
    private GlobalInfo globalInfo;

    public List<ChatChannel> getList() {
        return new ArrayList<>(chatChannelMap.values());
    }

    public void add(ChatChannel chatChannel) {
        chatChannelMap.put(chatChannel.getChannelId(), chatChannel);
        selectListItemMap.put(chatChannel.getChannelId(), new ChannelItem(chatChannel));
    }

    public void remove(ChatChannel chatChannel) {
        chatChannelMap.remove(chatChannel.getChannelId());
        selectListItemMap.remove(chatChannel.getChannelId());
    }

    public ChatChannel getChannel( Long channelId) {
        return chatChannelMap.get(channelId);
    }

    public void updateUI() {
        if (globalInfo.getSideBarSelectionType().get()!=0){
            return;
        }
        ObservableEmitter<ChannelListControllerFun> chatChannelObservableEmitter = channelListControllerOE.getChatChannelObservableEmitter();
        if (chatChannelObservableEmitter == null) {
            return;
        }
        chatChannelObservableEmitter.onNext(() -> new ArrayList<>(selectListItemMap.values()));
    }
}
