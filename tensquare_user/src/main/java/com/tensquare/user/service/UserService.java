package com.tensquare.user.service;

import com.tensquare.user.pojo.inner.RequestMsg;

import java.util.Map;

public interface UserService {
    void sendSmsCode(String mobile) throws Exception;

    Map<String, Object> registerUser(RequestMsg requestMsg) throws Exception;

}
