package indi.midreamsheep.schatapp.desktop.manager;

import indi.midreamsheep.schatapp.desktop.manager.server.Server;
import indi.midreamsheep.schatapp.desktop.manager.server.ServerData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class GlobalManager {
    private List<Server> serverList = new LinkedList<>();
    private Server currentServer;
    public static GlobalManager build(){
        GlobalManager globalManager = new GlobalManager();
        globalManager.setServerList(new LinkedList<>());
        List<Server> serverList1 = globalManager.getServerList();

        Server testServer1 = Server.buildServer();
        ServerData testServer1Data = testServer1.getServerData();
        testServer1Data.setName("testServer1");
        testServer1Data.setHeadPictureUrl("https://avatars.githubusercontent.com/u/93137426?v=4");
        testServer1.setServerData(testServer1Data);

        Server testServer2 = Server.buildServer();
        ServerData testServer2Data = testServer2.getServerData();
        testServer2Data.setName("testServer2");
        testServer2Data.setHeadPictureUrl("https://upload.jianshu.io/users/upload_avatars/1447174/5b2925ac-99cb-4efc-b3b5-826eb4895273.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240");
        testServer2.setServerData(testServer2Data);

        serverList1.add(testServer1);
        serverList1.add(testServer2);
        globalManager.setCurrentServer(serverList1.get(0));
        return globalManager;
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
}
