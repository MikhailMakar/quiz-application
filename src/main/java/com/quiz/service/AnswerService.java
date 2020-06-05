package com.quiz.service;

import com.quiz.model.Answer;
import java.util.List;

public interface AnswerService {

    Answer createAnswer(Answer answer);

    void deleteById(long id);

    Answer getAnswerById(long id);

    List<Answer> getAnswers();
}
