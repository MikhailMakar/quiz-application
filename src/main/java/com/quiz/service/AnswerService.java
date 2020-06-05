package com.quiz.service;

import com.quiz.dto.AnswerDto;
import com.quiz.model.Answer;
import java.util.List;

public interface AnswerService {

    Answer createAnswer(AnswerDto answerDto);

    void delete(long id);

    Answer getAnswer(long id);

    List<Answer> getAnswers();
}
