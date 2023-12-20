package com.profit.common.constant;

public enum JobEnum {
    /**
     * 统计数据
     */
    SYS_STATISTICS_JOB("sys_statistics_Job", 1);

    private String name;
    private long code;

    JobEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
