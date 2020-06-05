package com.quiz.controller;

import com.quiz.dto.AnswerDto;
import com.quiz.dto.ListForDto;
import com.quiz.service.AnswerService;
import com.quiz.util.GenericModelMapper;
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
    public AnswerDto createAnswer(@RequestBody AnswerDto answerDto) {
        return GenericModelMapper.convertToClass(answerService.createAnswer(answerDto), AnswerDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById(@PathVariable long id) {
        answerService.delete(id);
    }

    @GetMapping("/{id}")
    public AnswerDto getAnswer(@PathVariable long id) {
        return GenericModelMapper.convertToClass(answerService.getAnswer(id), AnswerDto.class);
    }

    @GetMapping("/all")
    public ListForDto<AnswerDto> getAllAnswers() {
        return GenericModelMapper.convertList(new ListForDto<>(answerService.getAnswers()), AnswerDto.class);
    }
}
