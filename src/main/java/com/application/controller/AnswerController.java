package com.application.controller;

import com.application.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
}
