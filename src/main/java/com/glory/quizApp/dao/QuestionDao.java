package com.glory.quizApp.dao;

import com.glory.quizApp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {


    // Type of Data to return is ListOfQuestions on Line(14)
    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ ",
            nativeQuery = true)
   // List<Questions> findRandomQuestionsByCategory(String category, int numQ);
    List<Questions> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
