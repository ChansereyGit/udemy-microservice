package com.learning.accounts.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {
    private Long accountNumber;
    private String email;
    private String accountType;
    private String branchAddress;
}
