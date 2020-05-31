package com.application.controller;

import com.application.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
}
