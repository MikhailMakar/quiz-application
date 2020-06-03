package com.quiz.model;

import javax.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String answerValue;

    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;
}
