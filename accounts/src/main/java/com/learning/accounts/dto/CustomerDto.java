package com.learning.accounts.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of name should be in between of 5 and 30 characters")
    private String name;

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email address is invalid")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
