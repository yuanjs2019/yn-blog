package com.yuan.farmerwork.ynblog.utils;

/**
 * 基本异常类.
 * 包含errorCode会被自动解析成返回code
 *
 * @author
 */
public class BaseException extends RuntimeException {
    /**
     * 错误代码.
     */
    private int errorCode;

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public BaseException(int errorCode, String message, Throwable cause) {
        super(message, cause, false, false);
        this.errorCode = errorCode;
    }

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public BaseException(int errorCode, String message) {
        super(message, null, false, false);
        this.errorCode = errorCode;
    }

    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public BaseException(String message) {
        super(message, null, false, false);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
