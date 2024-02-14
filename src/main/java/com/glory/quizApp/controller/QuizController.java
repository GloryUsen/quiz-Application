package com.glory.quizApp.controller;

import com.glory.quizApp.model.QuestionWrapper;
import com.glory.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ, @RequestParam String tittle){
      return quizService.createQuiz(category, numQ, tittle);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id ){
        return quizService.getQuizQuestions(id);


    }
}
