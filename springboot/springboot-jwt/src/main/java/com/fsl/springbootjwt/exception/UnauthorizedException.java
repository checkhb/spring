package com.fsl.springbootjwt.exception;

/**
 * UnauthorizedException
 * @author sj2
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
