package com.exam.app.service;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import com.exam.app.dao.Questionrepo;
import com.exam.app.model.Question;

@Service
public class QuestionSer {
    @Autowired
    Questionrepo repo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try { 
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByQsubject(String qsubject) {
        try {
            return new ResponseEntity<>(repo.findByQsubject(qsubject), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<String> editQuestion(int id, Question question) {
        if (repo.existsById(id)){
            question.setId(id);
            repo.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Question not found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Question not found",HttpStatus.NOT_FOUND);
    }

}
