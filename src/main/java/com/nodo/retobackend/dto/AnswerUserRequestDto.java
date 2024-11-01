package com.nodo.retobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerUserRequestDto {
    private String documentNumber;
    private List<AnswerRequestDto> answers;
}
