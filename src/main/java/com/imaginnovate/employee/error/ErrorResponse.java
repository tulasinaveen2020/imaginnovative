package com.imaginnovate.employee.error;

import lombok.Data;

@Data
public class ErrorResponse {

    private long errorCode;
    private String errorMessage;
}
