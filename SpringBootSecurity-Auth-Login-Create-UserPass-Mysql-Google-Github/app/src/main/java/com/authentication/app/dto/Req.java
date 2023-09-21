package com.authentication.app.dto;
import lombok.Data;
import java.util.List;

@Data
public class Req {
    private List<Searchreq> search;
    private Operators operator;
    public enum Operators{
        AND, OR;
    }
}