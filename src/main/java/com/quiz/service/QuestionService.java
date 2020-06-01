package com.quiz.service;

import com.quiz.model.Question;
import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    Question updateQuestion(Long id, Question question);

    void removeQuestion(Long id);

    Question getQuestion(Long id);

    List<Question> getQuestions();
}
