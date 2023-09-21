package com.exam.app.model;
import lombok.Data;
@Data
public class Qview {

    private Integer id;
    private String title;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    
    public Qview(Integer id, String title, String opt1, String opt2, String opt3, String opt4) {
        this.id = id;
        this.title = title;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
    }
    
}
