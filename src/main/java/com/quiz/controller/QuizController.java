package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuizById(@PathVariable long id) {
        quizService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable long id) {
        return quizService.getQuizById(id);
    }

    @GetMapping("/all")
    public List<Quiz> getAllQuizzes() {
        return quizService.getQuizzes();
    }
}
