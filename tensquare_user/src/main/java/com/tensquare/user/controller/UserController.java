package com.tensquare.user.controller;

import com.tensquare.user.pojo.inner.RequestMsg;
import com.tensquare.user.service.UserService;
import constants.StatusCode;
import constants.user.ResultCode;
import dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/smsCode")
    public ResultDTO sendSmsCheckCode(@RequestParam String mobile) throws Exception {

        userService.sendSmsCode(mobile);

        return new ResultDTO(true, StatusCode.OK, "消息发送成功");
    }

    @PostMapping("/register")
    public ResultDTO registerUser(@RequestBody RequestMsg requestMsg) throws Exception {

        Map<String, Object> map = userService.registerUser(requestMsg);

        if (ResultCode.USER_REGISTER.getMessage().equals((String) map.get("msg"))) {
            return new ResultDTO(true, StatusCode.OK, (String) map.get("msg"));
        } else {
            return new ResultDTO(false, StatusCode.ERROR, (String) map.get("msg"));
        }
    }
}
