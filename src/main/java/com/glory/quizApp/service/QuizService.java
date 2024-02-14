package com.glory.quizApp.service;

import com.glory.quizApp.dao.QuestionDao;
import com.glory.quizApp.dao.QuizDao;
import com.glory.quizApp.model.QuestionWrapper;
import com.glory.quizApp.model.Questions;
import com.glory.quizApp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle) {

        List<Questions> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTittle(tittle);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
         return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
         List<Questions> questionsFromDb = quiz.get().getQuestions();
         List<QuestionWrapper> questionsForUser = new ArrayList<>();

         for(Questions q : questionsFromDb){
             QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionsTittle(), q.getOption1(),
                     q.getOption2(), q.getOption3(), q.getOption4());
             questionsForUser.add(qw);
         }

         return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
