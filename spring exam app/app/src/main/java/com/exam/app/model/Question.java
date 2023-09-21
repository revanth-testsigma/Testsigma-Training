package com.exam.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;
    private String level;
    private String qsubject;
}
