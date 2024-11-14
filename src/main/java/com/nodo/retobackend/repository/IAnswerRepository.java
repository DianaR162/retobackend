package com.nodo.retobackend.repository;

import com.nodo.retobackend.model.Answer.Answer;
import com.nodo.retobackend.model.Answer.AnswerId;
import com.nodo.retobackend.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, AnswerId> {

    @Query("SELECT a FROM Answer a WHERE a.user.documentNumber = :userDocument AND a.questionOption.question.id = :questionId")
    Optional<Answer> findByUserDocumentAndQuestionId(@Param("userDocument") String userDocument, @Param("questionId") Long questionId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO answers(id_question_option, id_user) VALUES(:questionOptionId, :userId)", nativeQuery = true)
    void saveNative(@Param("questionOptionId") Long questionOptionId, @Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("UPDATE Answer a SET a.questionOption = :questionOption WHERE a.id = :id")
    void updateQuestionOption(@Param("questionOption") QuestionOption questionOption, @Param("id") AnswerId id);
}
