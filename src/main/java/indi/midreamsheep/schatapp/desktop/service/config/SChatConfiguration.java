package indi.midreamsheep.schatapp.desktop.service.config;

import indi.midreamsheep.schatapp.desktop.service.handler.DeleteHandler;
import indi.midreamsheep.schatapp.desktop.service.handler.EditHandler;
import indi.midreamsheep.schatapp.desktop.service.handler.SendHandler;
import indi.midreamsheep.schatapp.frame.net.api.handler.ChatTypeHandlerConfiguration;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.TransmissionEnum;

import java.util.HashMap;
import java.util.Map;

public class SChatConfiguration implements ChatTypeHandlerConfiguration {
    @Override
    public Map<Integer, ChatHandler> getTypeHandlerMap() {
        Map<Integer,ChatHandler> map = new HashMap<>();
        map.put(TransmissionEnum.SEND_MESSAGE.getCode(), new SendHandler());
        map.put(TransmissionEnum.DELETE_MESSAGE.getCode(), new DeleteHandler());
        map.put(TransmissionEnum.EDIT_MESSAGE.getCode(), new EditHandler());
        return map;
    }
}
