package indi.midreamsheep.schatapp.desktop.ui.controller.sidebar;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;

import java.util.Map;

@FunctionalInterface
public interface ChannelListControllerFun {
    void change(Map<Long, ChatChannel> chatChannelMap);
}
