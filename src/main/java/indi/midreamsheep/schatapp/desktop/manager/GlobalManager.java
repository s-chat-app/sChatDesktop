package indi.midreamsheep.schatapp.desktop.manager;

import androidx.compose.runtime.MutableState;
import indi.midreamsheep.schatapp.desktop.manager.server.Server;
import indi.midreamsheep.schatapp.desktop.service.command.UpdateSignal;
import indi.midreamsheep.schatapp.desktop.service.config.SChatConfiguration;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;
import io.reactivex.ObservableEmitter;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class GlobalManager {

    public static GlobalManager RECOMPOSE = new GlobalManager();

    private List<Server> serverList = new LinkedList<>();
    private Server currentServer;
    public static GlobalManager build(ObservableEmitter<UpdateSignal> emitter) throws InterruptedException {
        GlobalManager globalManager = new GlobalManager();
        //TODO 通过配置文件获取服务器数据
        //globalManager.getServerList().add(null/*服务器信息*/);
        //设置第一个服务器为当前
        globalManager.setCurrentServer(globalManager.getServerList().get(0));
        for (Server server : globalManager.getServerList()) {
            //TODO　对服务进行初始化
            server.init();
            //TODO 对服务器启动netty服务器监听
            SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
            builder.addTypeHandler(new SChatConfiguration(emitter));
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

}
