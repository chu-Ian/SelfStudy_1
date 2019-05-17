package constants;

/**
 * 状态码
 */
public interface StatusCode {

    public static final int OK = 20000; //成功
    int ERROR = 20001; //失败
    int LOGINERROR = 20002; //用户名和密码错误
    int ACCESSERROR = 20003; //权限不足
    int REMOTEERROR = 20004; //远程调用失败
    int REPERROR = 2005; //重复操作
    int ERRORPARAMS = 2006; //错误的参数
}
