package com.quiz.dto;

import com.quiz.model.Question;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto {

    private long id;

    private String quizName;

    private List<Question> questions;
}
