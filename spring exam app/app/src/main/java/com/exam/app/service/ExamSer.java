package com.exam.app.service;

import com.exam.app.dao.Questionrepo;
import com.exam.app.dao.Examrepo;
import com.exam.app.model.Question;
import com.exam.app.model.Qview;
import com.exam.app.model.Exam;
import com.exam.app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamSer {

    @Autowired
    Examrepo erepo;
    @Autowired
    Questionrepo qrepo;

    public ResponseEntity<String> createExam(String qsubject, int numQ, String title) {

        List<Question> questions = qrepo.findRandomQuestionsByQsubject(qsubject, numQ);
        Exam exam = new Exam();
        exam.setTitle(title);
        exam.setQuestions(questions);
        exam.setEsubject(qsubject);
        exam.setEtime(30);
        erepo.save(exam);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Qview>> getExamQuestions(Integer id) {
        Optional<Exam> resexam = erepo.findById(id);
        List<Qview> questionsForUser = new ArrayList<>();
        if(resexam.isPresent()){
        List<Question> questionsFromDB = resexam.get().getQuestions();
        for(Question q : questionsFromDB){
            Qview qv = new Qview(q.getId(), q.getTitle(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4());
            questionsForUser.add(qv);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Exam exam = erepo.findById(id).get();
        List<Question> questions = exam.getQuestions();
        int score = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getAnswer()))
                score++;

            i++;
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}