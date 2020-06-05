package com.quiz.service.impl;

import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.service.QuestionService;
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
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Question getQuestionById(long id) {
        return questionRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }
}
