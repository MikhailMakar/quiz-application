package com.quiz.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "answer_value")
    private String answerValue;

    @Column(name = "is_correct")
    private boolean isCorrect;
}
