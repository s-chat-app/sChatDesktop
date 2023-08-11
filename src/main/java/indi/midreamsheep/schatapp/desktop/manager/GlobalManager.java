package indi.midreamsheep.schatapp.desktop.manager;

import androidx.compose.runtime.MutableState;
import indi.midreamsheep.schatapp.desktop.manager.chat.AbstractInfo;
import indi.midreamsheep.schatapp.desktop.manager.chat.individual.FriendUserInfo;
import indi.midreamsheep.schatapp.desktop.manager.chat.individual.IndividualManager;
import indi.midreamsheep.schatapp.desktop.manager.server.Server;
import indi.midreamsheep.schatapp.desktop.manager.server.ServerData;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;

import java.util.LinkedList;
import java.util.List;

public class GlobalManager {

    public static GlobalManager RECOMPOSE = new GlobalManager();

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
        testServer1.getServerMeta().setId(5595955);

        IndividualManager individualManager = testServer1.getIndividualManager();
        individualManager.addChat(new FriendUserInfo(123, ChatType.INDIVIDUAL,"onear","https://avatars.githubusercontent.com/u/93137426?v=4"));
        individualManager.addChat(new FriendUserInfo(1234, ChatType.INDIVIDUAL,"midream","https://upload.jianshu.io/users/upload_avatars/1447174/5b2925ac-99cb-4efc-b3b5-826eb4895273.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240"));

        testServer1.setCurrentInfo(individualManager.getChatList().get(0));

        Server testServer2 = Server.buildServer();
        ServerData testServer2Data = testServer2.getServerData();
        testServer2Data.setName("testServer2");
        testServer2Data.setHeadPictureUrl("https://upload.jianshu.io/users/upload_avatars/1447174/5b2925ac-99cb-4efc-b3b5-826eb4895273.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240");
        testServer2.getServerMeta().setId(4844548);

        individualManager = testServer2.getIndividualManager();
        individualManager.addChat(new FriendUserInfo(123, ChatType.INDIVIDUAL,"onear","https://upload.jianshu.io/users/upload_avatars/1447174/5b2925ac-99cb-4efc-b3b5-826eb4895273.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240"));
        individualManager.addChat(new FriendUserInfo(1234, ChatType.INDIVIDUAL,"midream","https://avatars.githubusercontent.com/u/93137426?v=4"));

        testServer2.setCurrentInfo(individualManager.getChatList().get(0));

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

    public static void setCurrentServer(MutableState<GlobalManager> manager, Server server){
        GlobalManager a = manager.getValue();
        a.setCurrentServer(server);
        manager.setValue(GlobalManager.RECOMPOSE);
        manager.setValue(a);
    }


}
