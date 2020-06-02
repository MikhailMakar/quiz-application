package com.quiz.service.impl;

import com.quiz.dto.QuizDto;
import com.quiz.model.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;
import com.quiz.util.GenericModelMapper;
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
    public Quiz createQuiz(QuizDto quizDto) {
        return quizRepository.save(GenericModelMapper.convertToClass(quizDto, Quiz.class));
    }

    @Transactional
    @Override
    public void deleteQuiz(long id) {
        quizRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Quiz getQuiz(long id) {
        return quizRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }
}
