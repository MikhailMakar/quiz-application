package com.quiz.service;

import com.quiz.model.Question;
import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    void deleteById(long id);

    Question getQuestionById(long id);

    List<Question> getQuestions();
}
