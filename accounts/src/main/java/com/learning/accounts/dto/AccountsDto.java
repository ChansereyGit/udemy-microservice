package com.learning.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Accounts",
        description = "Account details"
)
public class AccountsDto {

    @Schema(
            description = "account number"
    )
    @NotEmpty(message = "account number cannot be not null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "account type",
            example = "savings"
    )
    @NotEmpty(message = "account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "branch account address",
            example = "1123st, New York, NY"
    )
    @NotEmpty(message = "branch address cannot be null or empty")
    private String branchAddress;
}
