package com.quiz.service.impl;

import com.quiz.model.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Transactional
    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Transactional
    @Override
    public void removeQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Quiz getQuiz(Long id) {
        return quizRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }
}
