package com.application.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name = "quizzes")
public class Quiz extends BaseEntity {

    private List<Question> questions;
}
