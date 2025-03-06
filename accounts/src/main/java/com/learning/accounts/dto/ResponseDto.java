package com.learning.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Response information"
)
public class ResponseDto {

    @Schema(
            description = "status code"
    )
    private String statusCode;
    @Schema(
            description = "status message"
    )
    private String statusMsg;
}
