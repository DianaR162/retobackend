package com.nodo.retobackend.dto;

import com.nodo.retobackend.model.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionResponseDto {
    private Long id;
    private String section;
    private String question;
    private List<Option> options;
}
