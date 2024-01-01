package indi.midreamsheep.schatapp.desktop.entity.account.chat.channel;

import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ChannelManger {
    private final Map<Long, ChatChannel> channelMap = new HashMap<>();

    public void addChannel(ChatChannel channel){
        channelMap.put(channel.getChannelId(),channel);
    }

    public void removeChannel(ChatChannel channel){
        channelMap.remove(channel.getChannelId());
    }

    public ChatChannel getChannel(long channelId){
        return channelMap.get(channelId);
    }

    public ChatChannel getChannel(String channelName){
        for (ChatChannel channel : channelMap.values()) {
            if (channel.getName().equals(channelName)) {
                return channel;
            }
        }
        return null;
    }

    public List<ChatChannel> getChannels(){
        return new ArrayList<>(channelMap.values());
    }

    public void clear(){
        channelMap.clear();
    }

    public boolean isEmpty(){
        return channelMap.isEmpty();
    }

}
