package com.quiz.controller;

import com.quiz.service.impl.AnswerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerServiceImpl answerService;
}
