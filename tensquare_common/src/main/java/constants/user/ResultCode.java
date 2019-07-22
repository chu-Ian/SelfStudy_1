package constants.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    USER_REGISTER("111", "注册成功"),

    USER_EXIST("000","该用户已存在，请直接登录"),

    CODE_EXPIRE("001","验证码过期，请重新发送"),

    CODE_ERROR("002","验证码不正确，请重新输入");

    private String code;
    private String message;
    }
