package com.application.controller;

import com.application.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
}
