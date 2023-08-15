package indi.midreamsheep.schatapp.desktop.service.config;

import indi.midreamsheep.schatapp.desktop.service.update.UpdateSignal;
import indi.midreamsheep.schatapp.desktop.service.handler.type.DeleteHandler;
import indi.midreamsheep.schatapp.desktop.service.handler.type.EditHandler;
import indi.midreamsheep.schatapp.desktop.service.handler.type.SendHandler;
import indi.midreamsheep.schatapp.frame.net.api.handler.ChatTypeHandlerConfiguration;
import indi.midreamsheep.schatapp.frame.net.api.handler.type.ChatHandler;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.TransmissionEnum;
import io.reactivex.ObservableEmitter;

import java.util.HashMap;
import java.util.Map;

public class SChatConfiguration implements ChatTypeHandlerConfiguration {

    private final ObservableEmitter<UpdateSignal> emitter;

    public SChatConfiguration(ObservableEmitter<UpdateSignal> emitter){
        this.emitter = emitter;
    }


    @Override
    public Map<Integer, ChatHandler> getTypeHandlerMap() {
        Map<Integer,ChatHandler> map = new HashMap<>();
        map.put(TransmissionEnum.SEND_MESSAGE.getCode(), new SendHandler(emitter));
        map.put(TransmissionEnum.DELETE_MESSAGE.getCode(), new DeleteHandler(emitter));
        map.put(TransmissionEnum.EDIT_MESSAGE.getCode(), new EditHandler(emitter));
        return map;
    }
}
