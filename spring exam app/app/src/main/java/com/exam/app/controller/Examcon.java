package com.exam.app.controller;

import com.exam.app.dao.Examrepo;
import com.exam.app.dto.Req;
import com.exam.app.dto.Searchreq;
import com.exam.app.model.Exam;
import com.exam.app.model.Qview;
import com.exam.app.model.Response;
import com.exam.app.service.ExamSer;
import com.exam.app.service.FiltersSpecification;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("exam")
public class Examcon {
    
    @Autowired
    ExamSer examSer;
    Examrepo erepo;

    public Examcon(Examrepo erepo) {
        this.erepo = erepo;
    }
    @PostMapping("create")
    public ResponseEntity<String> createExam(@RequestParam String qsubject, @RequestParam int numQ, @RequestParam String title){
        return examSer.createExam(qsubject,numQ, title);
    }
    @PutMapping("create")
    public ResponseEntity<String> createExa(@RequestBody Map<String, String> req){
        return examSer.createExam(req.get("qsubject"), Integer.parseInt(req.get("numQ")), req.get("title"));
    }
    
    @GetMapping("load/{id}")
    public ResponseEntity<List<Qview>> getQuizQuestions(@PathVariable Integer id){
        return examSer.getExamQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitExam(@PathVariable Integer id, @RequestBody List<Response> responses){
        return examSer.calculateResult(id, responses);
    }

    //specifications

    @Autowired
    private FiltersSpecification<Exam> ExamFiltersSpecification;
    
    @GetMapping
    public List<Exam> index(@RequestBody Searchreq search) {

        Specification<Exam> searchSpecification = ExamFiltersSpecification
                .getSearchSpecification(search);
            return erepo.findAll(searchSpecification);
    }

    @Transactional
    @DeleteMapping
    public long index1(@RequestBody Searchreq search) {
        Specification<Exam> searchSpecification = ExamFiltersSpecification
                .getSearchSpecification(search);
            return erepo.delete(searchSpecification);
    }
    
    @Transactional
    @DeleteMapping("/filter")
    public long index1(@RequestBody Req request) {
        System.out.println(request);
        Specification<Exam> searchSpecification = ExamFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());
            return erepo.delete(searchSpecification);
    }
    
    @GetMapping("/filter")
    public List<Exam> index(@RequestBody Req request) {
        Specification<Exam> searchSpecification = ExamFiltersSpecification
                .getSearchSpecification(request.getSearch(), request.getOperator());

            return erepo.findAll(searchSpecification);
    }
}