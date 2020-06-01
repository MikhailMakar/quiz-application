package com.quiz.controller;

import com.quiz.service.impl.QuestionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionServiceImpl questionService;
}
