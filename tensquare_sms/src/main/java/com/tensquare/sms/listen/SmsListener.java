package com.tensquare.sms.listen;

import com.alibaba.fastjson.JSON;
import com.tensquare.sms.api.SmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class SmsListener {

    @Autowired
    private SmsClient smsClient;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "SMS.CODE", durable = "false"),
            exchange = @Exchange(value = "amq.topic",
                    ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC)
    ))
    public void getMobileCode(Map<String, Object> map) {
        log.info("Mq监听到的消息", JSON.toJSONString(map));
        smsClient.sendMobileCodeByMq(map);
    }
}
