package indi.midreamsheep.schatapp.desktop.entity.account.chat.server;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChannelManger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatServer {
    private long serverId;
    private String name;
    private long avatar;
    private ChannelManger channelManger;
}
