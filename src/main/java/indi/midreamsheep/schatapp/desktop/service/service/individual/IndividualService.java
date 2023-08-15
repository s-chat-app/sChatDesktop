package indi.midreamsheep.schatapp.desktop.service.service.individual;

import cn.hutool.core.util.IdUtil;
import indi.midreamsheep.schatapp.desktop.service.handler.id.SendRecall;
import indi.midreamsheep.schatapp.frame.net.api.handler.id.ChatHandlerIdRecall;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMapping;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatMessage;
import indi.midreamsheep.schatapp.frame.net.entity.chat.ChatType;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.message.MessageTransmissionStructure;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.message.MessageTypeEnum;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.message.text.TextMessage;
import indi.midreamsheep.schatapp.frame.net.entity.chat.protocol.transmission.SendMessage;
import indi.midreamsheep.schatapp.frame.net.service.AbstractService;
import indi.midreamsheep.schatapp.frame.net.util.json.JsonUtil;

public class IndividualService extends AbstractService {

    public void sendTextMessage(String message,long messageTo) {
        long id = IdUtil.getSnowflake().nextId();

        MessageTransmissionStructure messageTransmissionStructure = new MessageTransmissionStructure();
        messageTransmissionStructure.setMessageType(MessageTypeEnum.TEXT.getCode());
        messageTransmissionStructure.setData(JsonUtil.getBeanToJson(new TextMessage(message,-1)));

        SendMessage sendMessage = new SendMessage();
        sendMessage.setMessageTo(messageTo);
        sendMessage.setMessage(messageTransmissionStructure.toString());

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatType.INDIVIDUAL.getId());
        chatMessage.setMapping(ChatMapping.SEND.getMapping());
        chatMessage.setId(id);
        chatMessage.setData(sendMessage.toString());

        //注册处理回调
        ChatHandlerIdRecall.addRecall(id,new SendRecall());
        //写出数据
        channel.writeAndFlush(chatMessage.toString());
    }
}
