package indi.midreamsheep.schatapp.desktop.net.server;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;

import java.util.List;

public interface ServerNet {
    List<ChatChannel> getChatChannelList();
}
