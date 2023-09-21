package com.exam.app.dto;
import lombok.Data;

@Data
public class Searchreq{
    String column = "id";
    String value = "1";
    Operations operation = Operations.EQUAL;
    String joinTable;

    public enum Operations{
        EQUAL, LIKE, IN, GREATER_THAN, LESS_THAN, BETWEEN, JOIN;
    }

}