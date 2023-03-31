package com.simple.testing.common.exception;

import lombok.Getter;

/**
 * 错误码枚举类，用于统一服务端约定错误码
 *
 * @author older
 */
@Getter
public enum ErrorCode implements ErrorCodeConstants {
    /**
     * 通用异常
     */
    COMMON_ERROR(java.lang.Error.COMMON_ERROR, java.lang.Error.COMMON_ERROR_MSG),
    PARAMETER_ERROR(java.lang.Error.PARAMETER_ERROR, java.lang.Error.PARAMETER_ERROR_MSG),
    ;

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 仅做辅助使用，如果接口新增错误码但未及时发布或更新接口包则无法拿到枚举类
     *
     * @param code 错误码
     * @return 错误码枚举类
     */
    public static ErrorCode of(int code) {
        for (ErrorCode c : values()) {
            if (c.code == code) {
                return c;
            }
        }
        return null;
    }
}
