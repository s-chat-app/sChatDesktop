package indi.midreamsheep.schatapp.desktop.manager;

import cn.hutool.extra.mail.GlobalMailAccount;
import indi.midreamsheep.schatapp.desktop.manager.server.Server;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalManager {
    private List<Server> serverList = new LinkedList<>();
    private Server currentServer;
    public static GlobalManager build(){
        GlobalManager globalManager = new GlobalManager();
        globalManager.setServerList(new LinkedList<>());
        List<Server> serverList1 = globalManager.getServerList();
        serverList1.add(Server.buildServer());
        globalManager.setCurrentServer(serverList1.get(0));
        return globalManager;
    }
}
