package com.quiz.controller;

import com.quiz.model.Answer;
import com.quiz.service.AnswerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById(@PathVariable long id) {
        answerService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable long id) {
        return answerService.getAnswerById(id);
    }

    @GetMapping("/all")
    public List<Answer> getAllAnswers() {
        return answerService.getAnswers();
    }
}
