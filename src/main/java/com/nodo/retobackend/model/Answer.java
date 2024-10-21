package com.nodo.retobackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "id_question_option", nullable = false)
    private QuestionOption questionOption;
    @ManyToOne
    @JoinColumn(referencedColumnName = "document_number", name = "id_user", nullable = false)
    private User user;
}
