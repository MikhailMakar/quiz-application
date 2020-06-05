package com.quiz.controller;

import com.quiz.dto.ListForDto;
import com.quiz.dto.QuizDto;
import com.quiz.service.QuizService;
import com.quiz.util.GenericModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuizDto createQuiz(@RequestBody QuizDto quizDto) {
        return GenericModelMapper.convertToClass(quizService.createQuiz(quizDto), QuizDto.class);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuizById(@PathVariable long id) {
        quizService.delete(id);
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
