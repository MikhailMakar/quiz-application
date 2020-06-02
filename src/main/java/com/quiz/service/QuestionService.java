package com.quiz.service;

import com.quiz.dto.QuestionDto;
import com.quiz.model.Question;
import java.util.List;

public interface QuestionService {

    Question createQuestion(QuestionDto questionDto);

    void deleteQuestion(long id);

    Question getQuestion(long id);

    List<Question> getQuestions();
}
