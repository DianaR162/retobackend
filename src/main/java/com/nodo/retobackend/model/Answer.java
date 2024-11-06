package com.nodo.retobackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "id_question_option", nullable = false)
    private QuestionOption questionOption;
    @ManyToOne
    @JoinColumn(referencedColumnName = "document_number", name = "id_user", nullable = false)
    private User user;
}
