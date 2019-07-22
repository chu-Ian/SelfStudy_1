package com.tensquare.sms.controller;

import com.tensquare.sms.service.SmsService;
import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/mq/sendCode")
    public ResultDTO sendMobileCodeByMq(@RequestBody Map<String, Object> map) throws Exception {
        smsService.sendMobileCodeByMq(map);
        return new ResultDTO(true, StatusCode.OK, "短信发送成功");
    }
}
