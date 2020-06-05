package com.quiz.service.impl;

import com.quiz.model.Answer;
import com.quiz.repository.AnswerRepository;
import com.quiz.service.AnswerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional
    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        answerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Answer getAnswerById(long id) {
        return answerRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }
}
