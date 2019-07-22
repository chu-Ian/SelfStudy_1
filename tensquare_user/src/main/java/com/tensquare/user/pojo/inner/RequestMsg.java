package com.tensquare.user.pojo.inner;

import com.tensquare.user.pojo.User;
import lombok.Data;

@Data
public class RequestMsg {
    private User user;
    private String mobile;
    private String code;
}
