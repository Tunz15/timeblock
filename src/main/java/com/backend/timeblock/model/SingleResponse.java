package com.backend.timeblock.model;

import lombok.Data;

@Data
public class SingleResponse {
    private String responseMessage;
    private String responseCode;
    private Event data;
}
