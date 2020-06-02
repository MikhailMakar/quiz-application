package com.quiz.dto;

import com.quiz.model.Answer;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    private long id;

    private String questionValue;

    private List<Answer> answers;
}
