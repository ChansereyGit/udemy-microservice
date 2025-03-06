package com.learning.loans.service.impl;

import com.learning.loans.constants.LoansConstants;
import com.learning.loans.dto.LoansDto;
import com.learning.loans.entity.Loans;
import com.learning.loans.exception.LoansAlreadyExistException;
import com.learning.loans.exception.ResourceNotFoundException;
import com.learning.loans.mapper.LoansMapper;
import com.learning.loans.repository.LoansRepository;
import com.learning.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> optionalLoans = loansRepository.findByMobileNumber(mobileNumber);
        if(optionalLoans.isPresent()) {
            throw new LoansAlreadyExistException("Loan already registered with the given mobile number" + mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        return LoansMapper.maapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoanDetails(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }

    private Loans createNewLoan(String mobileNumber) {
        Loans newLoans = new Loans();
        newLoans.setMobileNumber(mobileNumber);
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoans.setLoanNumber(Long.toString(randomLoanNumber));
        newLoans.setLoanType(LoansConstants.HOME_LOAN);
        newLoans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoans.setAmountPaid(0);
        newLoans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoans;
    }
}
