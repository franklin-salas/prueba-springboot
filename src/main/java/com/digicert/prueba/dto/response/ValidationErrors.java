package com.digicert.prueba.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationErrors {

    private String message;
    private Map<String, String> errors;
    private Date timestamp;
    private int status;

}
