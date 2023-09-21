package com.ordersystem.app.dto;
import lombok.Data;

@Data
public class Searchreq{
    String column;
    String value;
    Operations operation;

    public enum Operations{
        EQUAL, LIKE, IN, GREATER_THAN, LESS_THAN, STARTS, ENDS, ASC, DESC;
    }

}