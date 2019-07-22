package com.tensquare.sms.service;

import com.aliyuncs.exceptions.ClientException;

import java.util.Map;

public interface SmsService {
    void sendMobileCodeByMq(Map<String, Object> map) throws Exception;
}
