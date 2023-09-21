package com.exam.app.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String esubject;
    private Integer etime;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Question> questions;  
}
