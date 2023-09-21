package com.exam.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.exam.app.model.Question;
import java.util.List;
@Repository
public interface Questionrepo extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question>{
    
    List<Question> findByQsubject(String qsubject);

    @Query(value = "SELECT * FROM question q Where q.qsubject=:qsubject ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByQsubject(@Param(value = "qsubject") String qsubject, @Param(value = "numQ") int numQ);
}
