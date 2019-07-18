package com.swedq.customer.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class RestFulException extends RuntimeException {
    private Map<String, Object> properties;
    private Integer errorCode;
    private String errorMessage;

    public RestFulException(Integer errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestFulException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}
