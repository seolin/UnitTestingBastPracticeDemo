package com.simple.testing.common.exception;

/**
 * 错误常量
 *
 * @author chenkangkang
 */
public interface ErrorCodeConstants {


    class Error {
        public static final int COMMON_ERROR = 10001;
        public static final String COMMON_ERROR_MSG = "未知异常";

        public static final int PARAMETER_ERROR = 10002;
        public static final String PARAMETER_ERROR_MSG = "参数错误, %s";
    }

}
