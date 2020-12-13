package vip.corejava.web.controller;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.corejava.stream.Barista;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2020/12/13
 */
@RestController
@Slf4j
public class BaristaController {

    @Autowired
    private Barista barista;

    @RequestMapping(value = "/stream/send")
    public boolean sendMessage(String message) {
        try {
            Map<String, Object> properties = new HashMap<>();
            properties.put("seq", RandomStringUtils.randomNumeric(10));
            MessageHeaders messageHeaders = new MessageHeaders(properties);
            Message msg = MessageBuilder.createMessage(message, messageHeaders);
            boolean sendResult = barista.logoutput().send(msg);
            return sendResult;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生产者发送数据失败");
        }
    }


    @StreamListener(Barista.INPUT_CHANNEL)
    public void receiver(Message message) throws IOException {
        Channel channel = (Channel) message.getHeaders().get(AmqpHeaders.CHANNEL);
        Long delieverTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        log.info("接收到消息" + message);
        channel.basicAck(delieverTag, false);
    }
}
