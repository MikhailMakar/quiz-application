package com.quiz.model;

import java.util.List;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question_value")
    private String questionValue;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
