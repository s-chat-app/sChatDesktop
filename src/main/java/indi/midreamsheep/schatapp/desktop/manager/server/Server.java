package indi.midreamsheep.schatapp.desktop.manager.server;

import androidx.compose.runtime.MutableState;
import indi.midreamsheep.schatapp.desktop.manager.chat.AbstractInfo;
import indi.midreamsheep.schatapp.desktop.manager.chat.channel.ChannelManager;
import indi.midreamsheep.schatapp.desktop.manager.chat.group.GroupManager;
import indi.midreamsheep.schatapp.desktop.manager.chat.individual.IndividualManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final Server RECOMPOSE = new Server();

    /**服务器元数据*/
    private ServerMeta serverMeta;
    /**服务数据*/
    private ServerData serverData;
    //服务器好友信息
    private IndividualManager individualManager;
/*    //服务器群组信息
    private GroupManager groupManager;
    //服务器通道信息
    private ChannelManager channelManager;*/
    private AbstractInfo currentInfo;

    //获取服务器元数据
    public static Server buildServer() {
        Server server = new Server();
        server.setServerMeta(new ServerMeta());
        server.setServerData(new ServerData());
        server.setIndividualManager(new IndividualManager());
/*        server.setGroupManager(new GroupManager());
        server.setChannelManager(new ChannelManager());*/
        return server;
    }

    public ServerMeta getServerMeta() {
        return serverMeta;
    }

    public void setServerMeta(ServerMeta serverMeta) {
        this.serverMeta = serverMeta;
    }

    public ServerData getServerData() {
        return serverData;
    }

    public void setServerData(ServerData serverData) {
        this.serverData = serverData;
    }

    public IndividualManager getIndividualManager() {
        return individualManager;
    }

    public void setIndividualManager(IndividualManager individualManager) {
        this.individualManager = individualManager;
    }

    public AbstractInfo getCurrentInfo() {
        return currentInfo;
    }

    public void setCurrentInfo(AbstractInfo currentInfo) {
        this.currentInfo = currentInfo;
    }

    public List<AbstractInfo> getInfos() {
        /*        infos.addAll(groupManager);
        infos.addAll(channelManager.getChannels());*/
        return new ArrayList<>(individualManager.getChatList());
    }

    public static void setCurrentInfo(MutableState<Server> server, AbstractInfo info){
        Server value = server.getValue();
        value.setCurrentInfo(info);
        server.setValue(RECOMPOSE);
        server.setValue(value);
    }
}
