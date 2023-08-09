package indi.midreamsheep.schatapp.desktop.service;

import indi.midreamsheep.schatapp.desktop.service.config.SChatConfiguration;
import indi.midreamsheep.schatapp.desktop.service.support.individual.IndividualService;
import indi.midreamsheep.schatapp.frame.net.SChatCommunication;
import indi.midreamsheep.schatapp.frame.net.SChatCommunicationBuilder;

public class NettyServer {

    SChatCommunication communication;

    //服务
    private IndividualService individualService;

    public void init(String ip,int port) throws InterruptedException {
        SChatCommunicationBuilder builder = new SChatCommunicationBuilder();
        builder.setServerSupporter(ip, port);
        builder.addTypeHandler(new SChatConfiguration());
        communication = builder.build();
        //注册service
        communication.registerService(individualService);
    }
}
