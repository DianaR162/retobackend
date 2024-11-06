package com.nodo.retobackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "question_options")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "id_question", nullable = false)
    private Question question;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "id_option", nullable = false)
    private Option option;
}
