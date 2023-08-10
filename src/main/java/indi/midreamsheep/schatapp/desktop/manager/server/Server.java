package indi.midreamsheep.schatapp.desktop.manager.server;

import indi.midreamsheep.schatapp.desktop.manager.chat.channel.ChannelManager;
import indi.midreamsheep.schatapp.desktop.manager.chat.group.GroupManager;
import indi.midreamsheep.schatapp.desktop.manager.chat.individual.IndividualManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    /**服务器元数据*/
    private ServerMeta serverMeta;
    /**服务数据*/
    private ServerData serverData;
    //服务器好友信息
    private IndividualManager individualManager;
    //服务器群组信息
    private GroupManager groupManager;
    //服务器通道信息
    private ChannelManager channelManager;

    //获取服务器元数据
    public static Server buildServer() {
        Server server = new Server();
        server.setServerMeta(new ServerMeta());
        server.setServerData(new ServerData());
        server.setIndividualManager(new IndividualManager());
        server.setGroupManager(new GroupManager());
        server.setChannelManager(new ChannelManager());
        return server;
    }
}
