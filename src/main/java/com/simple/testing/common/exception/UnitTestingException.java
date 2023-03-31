/**
 * AssetException.java
 * Copyright 2019 HelloBike , all rights reserved.
 * HelloBike PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.simple.testing.common.exception;

import lombok.Getter;

/**
 * @author oloer
 */
@Getter
public class UnitTestingException extends RuntimeException {
    private final ErrorCode carbonErrorCode;
    private final Object[] args;
    private Object data;

    public UnitTestingException(ErrorCode assetErrorCode, Object... args) {
        this.carbonErrorCode = assetErrorCode;
        this.args = args;
    }

    public UnitTestingException setData(Object data) {
        this.data = data;
        return this;
    }
}