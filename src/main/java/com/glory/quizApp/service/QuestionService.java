package com.glory.quizApp.service;

import com.glory.quizApp.dao.QuestionDao;
import com.glory.quizApp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Questions>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {

        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public String addQuestions(Questions questions) {
        try {
            questionDao.save(questions);
            return String.valueOf(new ResponseEntity<>("success", HttpStatus.CREATED));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "success";

    }
}
