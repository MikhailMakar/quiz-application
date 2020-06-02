package com.quiz.service.impl;

import com.quiz.model.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return null;
    }

    @Override
    public void removeQuiz(Long id) {

    }

    @Override
    public Quiz getQuiz(Long id) {
        return null;
    }

    @Override
    public List<Quiz> getQuizzes() {
        return null;
    }
}
