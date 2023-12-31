package indi.midreamsheep.schatapp.desktop.entity.account.chat.server;

import indi.midreamsheep.schatapp.desktop.entity.account.chat.channel.ChannelManger;
import indi.midreamsheep.schatapp.desktop.tool.image.ImageManager;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Comment;
import live.midreamsheep.frame.sioc.di.annotation.basic.comment.Injector;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Comment
public class ServerHandler {

    private ImageManager imageManager;

    private final Map<Long, ChatServer> channelMap = new HashMap<>();

    @Injector
    public ServerHandler(ImageManager imageManager){
        long chiTangId = imageManager.putImage(new File("/home/midreamsheep/workplace/schat/desktop/sChatDesktop/src/main/resources/icon/chi_tang.png"));
        long noneId = imageManager.putImage(new File("/home/midreamsheep/workplace/schat/desktop/sChatDesktop/src/main/resources/icon/none.png"));
        long userId = imageManager.putImage(new File("/home/midreamsheep/workplace/schat/desktop/sChatDesktop/src/main/resources/icon/user.png"));
        List<ChatServer> serverList = new ArrayList<>();
        serverList.add(new ChatServer(5L,"chi_tang",chiTangId,new ChannelManger()));
        serverList.add(new ChatServer(3L,"none",noneId,new ChannelManger()));
        serverList.add(new ChatServer(4L,"user",userId,new ChannelManger()));
        for (ChatServer friendChatChannel : serverList) {
            channelMap.put(friendChatChannel.getServerId(),friendChatChannel);
        }
    }

    public void addChannel(ChatServer channel){
        channelMap.put(channel.getServerId(),channel);
    }

    public void removeChannel(ChatServer channel){
        channelMap.remove(channel.getServerId());
    }

    public ChatServer getChannel(long channelId){
        return channelMap.get(channelId);
    }

    public ChatServer getChannel(String channelName){
        for (ChatServer channel : channelMap.values()) {
            if (channel.getName().equals(channelName)) {
                return channel;
            }
        }
        return null;
    }

    public List<ChatServer> getChannels(){
        return new ArrayList<>(channelMap.values());
    }
}
