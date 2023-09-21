package com.exam.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.exam.app.model.Exam;

@Repository
public interface Examrepo extends JpaRepository<Exam, Integer>, JpaSpecificationExecutor<Exam>{
    
}
