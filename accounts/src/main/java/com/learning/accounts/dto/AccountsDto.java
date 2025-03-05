package com.learning.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {

    @NotEmpty(message = "account number cannot be not null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "account type cannot be null or empty")
    private String accountType;

    @NotEmpty(message = "branch address cannot be null or empty")
    private String branchAddress;
}
