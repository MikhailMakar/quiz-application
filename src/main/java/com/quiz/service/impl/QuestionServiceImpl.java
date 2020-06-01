package com.quiz.service.impl;

import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        return null;
    }

    @Override
    public void removeQuestion(Long id) {

    }

    @Override
    public Question getQuestion(Long id) {
        return null;
    }

    @Override
    public List<Question> getQuestions() {
        return null;
    }
}
