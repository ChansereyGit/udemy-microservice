package com.learning.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Customer",
        description = "Customer details"
)
public class CustomerDto {

    @Schema(
            description = "Customer name",
            example = "john doe"
    )
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of name should be in between of 5 and 30 characters")
    private String name;

    @Schema(
            description = "Customer email",
            example = "john.doe@mail.com"
    )
    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email address is invalid")
    private String email;

    @Schema(
            description = "Customer mobile number",
            example = "1234567890"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account detail for customer"
    )
    private AccountsDto accountsDto;
}
