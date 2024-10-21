package com.nodo.retobackend.repository;

import com.nodo.retobackend.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
}
