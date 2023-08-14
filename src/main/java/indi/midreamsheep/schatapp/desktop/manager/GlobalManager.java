package indi.midreamsheep.schatapp.desktop.manager;

import androidx.compose.runtime.MutableState;
import indi.midreamsheep.schatapp.desktop.manager.server.Server;
import indi.midreamsheep.schatapp.desktop.service.command.SChatCommandment;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import io.reactivex.ObservableEmitter;

import java.util.LinkedList;
import java.util.List;

public class GlobalManager {

    public static GlobalManager RECOMPOSE = new GlobalManager();

    private List<Server> serverList = new LinkedList<>();
    private Server currentServer;
    public static GlobalManager build(ObservableEmitter<SChatCommandment> emitter) throws InterruptedException {
        GlobalManager globalManager = new GlobalManager();
        //TODO 通过配置文件获取服务器数据
        globalManager.getServerList().add(null/*服务器信息*/);
        //设置第一个服务器为当前
        globalManager.setCurrentServer(globalManager.getServerList().get(0));
        for (Server server : globalManager.getServerList()) {
            //TODO　对服务进行初始化
            server.init();
            //TODO 对服务器启动netty服务器监听
            SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
            Server.setBuilder(builder,emitter);
            builder.setServerSupporter(server.getServerMeta().getIp(),server.getServerMeta().getChannelPort());
            server.set(builder.build());
        }
        return globalManager;
    }

    public static void setCurrentServer(MutableState<GlobalManager> manager, Server server){
        GlobalManager a = manager.getValue();
        a.setCurrentServer(server);
        manager.setValue(GlobalManager.RECOMPOSE);
        manager.setValue(a);
    }

    public static void setRECOMPOSE(GlobalManager RECOMPOSE) {
        GlobalManager.RECOMPOSE = RECOMPOSE;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

    public Server getCurrentServer() {
        return currentServer;
    }

    public void setCurrentServer(Server currentServer) {
        this.currentServer = currentServer;
    }

    public static GlobalManager getRECOMPOSE() {
        return RECOMPOSE;
    }
}
