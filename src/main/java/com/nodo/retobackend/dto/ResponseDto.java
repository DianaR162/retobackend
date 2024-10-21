package com.nodo.retobackend.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDto<T> {
    private int status;
    private String message;
    private T data;
}
