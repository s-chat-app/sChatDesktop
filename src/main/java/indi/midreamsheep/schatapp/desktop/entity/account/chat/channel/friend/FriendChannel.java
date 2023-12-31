package indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.friend;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChatChannel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendChannel implements ChatChannel {
    private long channelId;
    private String name;
    private String lastMessage;
    private long lastMessageTime;
    private long avatar;
    private int unreadMessageCount;
}
