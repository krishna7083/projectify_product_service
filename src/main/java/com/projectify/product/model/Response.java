package com.projectify.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Response {
    private String error_code;
    private String error_message;
}
