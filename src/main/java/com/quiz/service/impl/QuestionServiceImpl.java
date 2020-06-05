package com.quiz.service.impl;

import com.quiz.dto.QuestionDto;
import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.service.QuestionService;
import com.quiz.util.GenericModelMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional
    @Override
    public Question createQuestion(QuestionDto questionDto) {
        return questionRepository.save(GenericModelMapper.convertToClass(questionDto, Question.class));
    }

    @Transactional
    @Override
    public void delete(long id) {
        questionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Question getQuestion(long id) {
        return questionRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
}
