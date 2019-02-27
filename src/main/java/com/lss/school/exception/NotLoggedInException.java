package com.lss.school.exception;

/**
 * @author Magic
 * @date 10:56 2018/4/8
 * @description
 */
public class NotLoggedInException extends RuntimeException{

    public NotLoggedInException() {
    }

    public NotLoggedInException(String message) {
        super(message);
    }
}
