package com.glory.quizApp.controller;


import com.glory.quizApp.model.Questions;
import com.glory.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Questions questions){  //
        return questionService.addQuestions(questions);

    }

}
