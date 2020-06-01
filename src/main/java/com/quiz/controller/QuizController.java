package com.quiz.controller;

import com.quiz.service.impl.QuizServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizServiceImpl quizService;
}
