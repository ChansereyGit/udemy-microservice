package com.learning.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Error Response Information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API Path invoke by client"
    )
    private String apiPath;

    @Schema(
            description = "Error Code Representing the Error Happened"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error Message Representing the Error Happened"
    )
    private String errorMessage;

    @Schema(
            description = "Time Representing when the Error Happened"
    )
    private LocalDateTime errorTime;
}
