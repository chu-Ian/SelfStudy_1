package com.tensquare.sms.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.config.SmsConfig;
import com.tensquare.sms.service.SmsService;
import com.tensquare.sms.utils.SmsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsConfig smsConfig;

    @Override
    public void sendMobileCodeByMq(Map<String, Object> map) throws Exception {
        log.info("短信验证码：" + JSON.toJSONString(map));

        String templateParam = "您的验证码为" + (String) map.get("code");
        map.put("templateParam", templateParam);

        try {
            SendSmsResponse smsResponse = SmsUtil.sendSms(map, smsConfig.getAccessKeyId(),
                    smsConfig.getAccessKeyScret(), smsConfig.getSignName(), smsConfig.getTemplateCode());
            log.info("短信接口返回的数据:{}" + JSON.toJSONString(smsResponse));
        } catch (ClientException e) {
            e.printStackTrace();
            throw new Exception("短信发送失败，请重新发送");
        }
    }
}
