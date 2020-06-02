package com.quiz.controller;

import com.quiz.common.RequestsInfo;
import com.quiz.dto.ListForDto;
import com.quiz.dto.QuestionDto;
import com.quiz.service.impl.QuestionServiceImpl;
import com.quiz.util.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestsInfo.QUESTIONS)
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionServiceImpl questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
        return GenericModelMapper.convertToClass(questionService.createQuestion(questionDto), QuestionDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@PathVariable long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping(RequestsInfo.ID)
    public QuestionDto getQuestion(@PathVariable long id) {
        return GenericModelMapper.convertToClass(questionService.getQuestion(id), QuestionDto.class);
    }

    @GetMapping(RequestsInfo.ALL)
    public ListForDto<QuestionDto> getAllQuestions() {
        return GenericModelMapper.convertList(new ListForDto<>(questionService.getQuestions()), QuestionDto.class);
    }
}
