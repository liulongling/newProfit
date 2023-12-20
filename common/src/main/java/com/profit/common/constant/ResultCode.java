package com.profit.common.constant;

/**
 * 一些返回值
 *
 * @author xiaotao
 */
public class ResultCode {

    /**
     * 成功
     */
    public static final int SUCCESS = 1;
    public static final String MSG_SUCCESS = "success";

    // 业务中细分的code 1000-1999
    /**
     * 用户名或密码错误
     */
    public static final int WRONG_USERNAME_OR_PASSWORD = 1000;
    public static final String MSG_WRONG_USERNAME_OR_PASSWORD = "wrong username or password";

    // 一些可能共性的异常code 9000~9999
    /**
     * 接口已下线
     */
    public static final int INTERFACE_OFFLINE = 9000;
    public static final String MSG_INTERFACE_OFFLINE = "interface is offline";

    /**
     * 数据库错误
     */
    public static final int DB_ERROR = 9001;
    public static final String MSG_DB_ERROR = "db error";

    /**
     * 参数非法
     */
    public static final int PARAMETER_INVALID = 9002;
    public static final String MSG_PARAMETER_INVALID = "parameter invalid";

    /**
     * 系统错误
     */
    public static final int ERROR_SYSTEM_EXCEPTION = 9999;
    public static final String MSG_ERROR_SYSTEM_EXCEPTION = "system error";

}
