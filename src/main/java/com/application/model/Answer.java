package com.application.model;

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
@Table(name = "answers")
public class Answer extends BaseEntity {

    @Column
    private String answer;

    @Column
    private boolean isTrue;
}
