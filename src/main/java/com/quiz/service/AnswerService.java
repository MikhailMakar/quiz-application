package com.quiz.service;

import com.quiz.model.Answer;
import java.util.List;

public interface AnswerService {

    Answer createAnswer(Answer answer);

    void removeAnswer(Long id);

    Answer getAnswer(Long id);

    List<Answer> getAnswers();
}
