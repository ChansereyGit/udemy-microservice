package com.learning.loans.service;

import com.learning.loans.dto.LoansDto;
import jakarta.validation.constraints.Pattern;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoanDetails(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);
}
