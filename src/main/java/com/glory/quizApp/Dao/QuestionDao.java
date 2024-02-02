package com.glory.quizApp.Dao;

import com.glory.quizApp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {


    // Type of Data to return is ListOfQuestions on Line(14)
    List<Questions> findByCategory(String category);
}
