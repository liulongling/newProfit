package com.profit.bond.dto;

/**
 * 返回值
 *
 * @author xiaotao
 */
public class ResultDO<T> {

    /**
     * 是否调用以及过参数校验
     */
    private Boolean success;
    /**
     * 业务code
     */
    private Integer code;
    /**
     * 业务消息
     */
    private String msg;
    /**
     * 返回值
     */
    private T module;

    public ResultDO(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public ResultDO(boolean success, Integer code, String msg, T module) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.module = module;
    }

    public void set(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public void set(boolean success, Integer code, String msg, T module) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.module = module;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResultDO [success=");
        builder.append(success);
        builder.append(", code=");
        builder.append(code);
        builder.append(", msg=");
        builder.append(msg);
        builder.append(", module=");
        builder.append(module);
        builder.append("]");
        return builder.toString();
    }

}
