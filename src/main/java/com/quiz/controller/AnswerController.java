package com.quiz.controller;

import com.quiz.common.RequestsInfo;
import com.quiz.dto.AnswerDto;
import com.quiz.dto.ListForDto;
import com.quiz.service.impl.AnswerServiceImpl;
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
@RequestMapping(RequestsInfo.ANSWERS)
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerServiceImpl answerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerDto createAnswer (@RequestBody AnswerDto answerDto) {
        return GenericModelMapper.convertToClass(answerService.createAnswer(answerDto), AnswerDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById (@PathVariable long id) {
        answerService.deleteAnswer(id);
    }

    @GetMapping(RequestsInfo.ID)
    public AnswerDto getAnswer(@PathVariable long id) {
        return GenericModelMapper.convertToClass(answerService.getAnswer(id), AnswerDto.class);
    }

    @GetMapping(RequestsInfo.ALL)
    public ListForDto<AnswerDto> getAllAnswers () {
        return GenericModelMapper.convertList(new ListForDto<>(answerService.getAnswers()), AnswerDto.class);
    }
}
