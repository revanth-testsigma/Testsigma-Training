package com.exam.app.controller;

import com.exam.app.dao.Questionrepo;
import com.exam.app.dto.Req;
import com.exam.app.dto.Searchreq;
import com.exam.app.model.Question;
import com.exam.app.service.QuestionSer;
import jakarta.transaction.Transactional;
import com.exam.app.service.FiltersSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class Questioncon {
    Questionrepo repo;
    public Questioncon(Questionrepo repo) {
        this.repo = repo;
    }
    @Autowired
    QuestionSer questionSer;

    @GetMapping("all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionSer.getAllQuestions();
    }

    @GetMapping("subject/{qsubject}")
    public ResponseEntity<List<Question>> getQuestionsByqsubject(@PathVariable String qsubject){
        return questionSer.getQuestionsByQsubject(qsubject);
    }

    @PutMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionSer.addQuestion(question);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<String> editQuestion(@PathVariable int id, @RequestBody Question question){
        return  questionSer.editQuestion(id,question);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionSer.deleteQuestion(id);
    }

    //specifications

    @Autowired
    private FiltersSpecification<Question> QuestionFiltersSpecification;
    
    @GetMapping
    public List<Question> index(@RequestBody Searchreq search) {
        System.out.println(search);
        Specification<Question> searchSpecification = QuestionFiltersSpecification
                .getSearchSpecification(search);
            return repo.findAll(searchSpecification);
    }

    @Transactional
    @DeleteMapping
    public long index1(@RequestBody Searchreq search) {
        System.out.println(search);
        Specification<Question> searchSpecification = QuestionFiltersSpecification
                .getSearchSpecification(search);
            return repo.delete(searchSpecification);
    }
    
    @Transactional
    @DeleteMapping("/filter")
    public long index1(@RequestBody Req request) {
        System.out.println(request);
        Specification<Question> searchSpecification = QuestionFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());
            return repo.delete(searchSpecification);
    }

    @GetMapping("/filter")
    public List<Question> index(@RequestBody Req request) {
        System.out.println(request);
        Specification<Question> searchSpecification = QuestionFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());

            return repo.findAll(searchSpecification);
    }

}