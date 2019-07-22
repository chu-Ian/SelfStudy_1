package com.tensquare.user.service.impl;

import com.google.common.collect.Maps;
import com.tensquare.user.dao.UserRepository;
import com.tensquare.user.pojo.inner.RequestMsg;
import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import constants.user.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendSmsCode(String mobile) throws Exception {
        //生成随机6位验证码
        String code = getRanData();
        log.info("生成的6为随机验证码：" + code);

        //把验证码放入redis中
        redisTemplate.opsForValue().set("SMSCODE" + mobile, code, 5, TimeUnit.MINUTES);

        //把手机号和验证码放入rabbitmq中，用于短信的发送
        Map<Object, Object> map = Maps.newHashMap();
        map.put("mobile", mobile);
        map.put("code", code);
        try {
            //存放到mq中用于短信发送
            rabbitTemplate.convertAndSend("SMS.CODE", map);
        } catch (AmqpException e) {
            log.info("rabbitmq发送消息失败");
            throw new Exception(e);
        }
    }

    @Override
    public Map<String, Object> registerUser(RequestMsg requestMsg) {
        Map<String, Object> map = Maps.newHashMap();

        User user = userRepository.findByMobile(requestMsg.getMobile());
        if (null != user) {
            log.info("该用户已存在，请直接登录");
            map.put("msg", ResultCode.USER_EXIST.getMessage());
            return map;
        }

        String s = redisTemplate.opsForValue().get("SMSCODE" + requestMsg.getMobile());
        if (StringUtils.isEmpty(s)) {
            log.info("验证码过期，请重新发送");
            map.put("msg", ResultCode.CODE_EXPIRE.getMessage());
            return map;
        }

        if (!s.equals(requestMsg.getCode())) {
            log.info("验证码不正确，请重新输入");
            map.put("msg", ResultCode.USER_EXIST.getMessage());
            return map;
        }

        userRepository.save(requestMsg.getUser());
        redisTemplate.delete("SMSCODE" + requestMsg.getMobile());

        map.put("msg", ResultCode.USER_REGISTER.getMessage());
        return map;
    }

    private String getRanData() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append("1234567890qwertyuiopasdfghjklzxcvbnm"
                    .charAt(new Random().nextInt("1234567890qwertyuiopasdfghjklzxcvbnm".length())));
        }

        return sb.toString();
    }
}
