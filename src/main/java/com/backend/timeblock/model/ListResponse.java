package com.backend.timeblock.model;

import java.util.List;

import lombok.Data;

@Data

public class ListResponse {
    private String responseMessage;
    private String responseCode;
    private List<Event> data;

}
