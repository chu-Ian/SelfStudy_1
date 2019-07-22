package com.tensquare.sms.api;

import dto.ResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("/tensquare-sms")
@RequestMapping("/sms")
public interface SmsClient {

    @PostMapping("/mq/sendCode")
    ResultDTO sendMobileCodeByMq(@RequestBody Map<String, Object> map);
}
