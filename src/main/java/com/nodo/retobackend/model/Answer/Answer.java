package com.nodo.retobackend.model.Answer;

import com.nodo.retobackend.model.QuestionOption;
import com.nodo.retobackend.model.User;
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
    @EmbeddedId
    private AnswerId id;

    @ManyToOne
    @MapsId("questionOptionId")
    @JoinColumn(name = "id_question_option", nullable = false)
    private QuestionOption questionOption;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user", referencedColumnName = "document_number", nullable = false)
    private User user;
}
