package com.quiz.service.impl;

import com.quiz.model.Answer;
import com.quiz.repository.AnswerRepository;
import com.quiz.service.AnswerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return null;
    }

    @Override
    public void removeAnswer(Long id) {

    }

    @Override
    public Answer getAnswer(Long id) {
        return null;
    }

    @Override
    public List<Answer> getAnswers() {
        return null;
    }
}
