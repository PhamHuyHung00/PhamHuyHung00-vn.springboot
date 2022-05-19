package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private HttpStatus httpStatus;
    private LocalDateTime currentDate;
    private String message;

}
