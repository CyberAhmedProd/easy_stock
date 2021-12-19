package com.teamyostrik.easystock.handlers;


import com.teamyostrik.easystock.exceptions.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private ErrorCode errorCode;
    private String message;
    private List<String> errors = new ArrayList<>();
}
