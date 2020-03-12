package com.videorent.exception;

public class BusinessException extends Exception {

    public BusinessException(String msg){
        super(msg);
    }

    public BusinessException(Throwable e){
        super(e);
    }

}
