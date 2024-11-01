package com.nodo.retobackend.repository;

import com.nodo.retobackend.model.Option;
import com.nodo.retobackend.model.Question;
import com.nodo.retobackend.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IQuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
    Optional<QuestionOption> findByQuestionAndOption(Question question, Option option);
}
