package com.microservices.order_Service.Exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{
    private final String message;
    private final int errorCode;

    public CustomException(String message, String notFound, int errorCode) {
        super(message);
        this.message = message;
       this.errorCode =errorCode;
    }
}
