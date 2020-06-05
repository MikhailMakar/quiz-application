package com.quiz.controller;

import com.quiz.dto.ListForDto;
import com.quiz.dto.QuizDto;
import com.quiz.service.impl.QuizServiceImpl;
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
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizServiceImpl quizService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuizDto createQuiz(@RequestBody QuizDto quizDto) {
        return GenericModelMapper.convertToClass(quizService.createQuiz(quizDto), QuizDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuizById(@PathVariable long id) {
        quizService.deleteQuiz(id);
    }

    @GetMapping("/{id}")
    public QuizDto getQuiz(@PathVariable long id) {
        return GenericModelMapper.convertToClass(quizService.getQuiz(id), QuizDto.class);
    }

    @GetMapping("/all")
    public ListForDto<QuizDto> getAllQuizzes() {
        return GenericModelMapper.convertList(new ListForDto<>(quizService.getQuizzes()), QuizDto.class);
    }
}
