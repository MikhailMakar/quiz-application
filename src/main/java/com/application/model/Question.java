package com.application.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "questions")
public class Question extends BaseEntity {

    @Column
    private String question;

    private List<Answer> answers;
}
