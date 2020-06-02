package com.quiz.service.impl;

import com.quiz.dto.AnswerDto;
import com.quiz.model.Answer;
import com.quiz.repository.AnswerRepository;
import com.quiz.service.AnswerService;
import com.quiz.util.GenericModelMapper;
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
    public Answer createAnswer(AnswerDto answerDto) {
        return answerRepository.save(GenericModelMapper.convertToClass(answerDto, Answer.class));
    }

    @Transactional
    @Override
    public void deleteAnswer(long id) {
        answerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Answer getAnswer(long id) {
        return answerRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }
}
