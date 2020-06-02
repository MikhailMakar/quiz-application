package com.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {

    private long id;

    private String answerValue;

    private boolean isCorrect;
}
