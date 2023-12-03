package com.lhc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    public final static int SUCCESS = 200;
    public final static int ERROR = 500;
    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 结果数据
     */
    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public static <T> Result<T> Success(T data) {
        return new Result<T>(SUCCESS, "成功", data);
    }

}
