package com.quiz.controller;

import com.quiz.dto.ListForDto;
import com.quiz.dto.QuestionDto;
import com.quiz.service.QuestionService;
import com.quiz.util.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
        return GenericModelMapper.convertToClass(questionService.createQuestion(questionDto), QuestionDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@PathVariable long id) {
        questionService.delete(id);
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestion(@PathVariable long id) {
        return GenericModelMapper.convertToClass(questionService.getQuestion(id), QuestionDto.class);
    }

    @GetMapping("/all")
    public ListForDto<QuestionDto> getAllQuestions() {
        return GenericModelMapper.convertList(new ListForDto<>(questionService.getQuestions()), QuestionDto.class);
    }
}
