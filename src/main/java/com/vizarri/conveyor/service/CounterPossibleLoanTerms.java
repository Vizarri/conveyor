package com.vizarri.conveyor.service;

import com.vizarri.conveyor.DTO.LoanApplicationRequestDTO;
import com.vizarri.conveyor.DTO.LoanOfferDTO;
import com.vizarri.conveyor.exceptionHandler.ConveyorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CounterPossibleLoanTerms {

    @Value("${basic.rate}")
    BigDecimal basicRate;

    public List<LoanOfferDTO> getPossibleLoanTerms(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        List<LoanOfferDTO> possibleLoanTerms = new ArrayList<>();
        if (loanApplicationRequestDTO == null) {
            throw new ConveyorException();
        }
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), getMonthlyInterestRate(basicRate.subtract(BigDecimal.valueOf(5L)))))
                        .rate(basicRate.subtract(BigDecimal.valueOf(5L)))
                        .isInsuranceEnabled(true)
                        .isSalaryClient(true)
                        .build());
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), getMonthlyInterestRate(basicRate.add(BigDecimal.valueOf(10L)))))
                        .rate(basicRate.add(BigDecimal.valueOf(10L)))
                        .isInsuranceEnabled(false)
                        .isSalaryClient(false)
                        .build());
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), getMonthlyInterestRate(basicRate.subtract(BigDecimal.valueOf(2L)))))
                        .rate(basicRate.subtract(BigDecimal.valueOf(2L)))
                        .isInsuranceEnabled(true)
                        .isSalaryClient(false)
                        .build());
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), getMonthlyInterestRate(basicRate)))
                        .rate(basicRate)
                        .isInsuranceEnabled(false)
                        .isSalaryClient(true)
                        .build());
        return possibleLoanTerms;
    }

    private BigDecimal countMonthlyPayment(Integer term, BigDecimal amount, BigDecimal monthlyInterestRate) {
        return amount
                .multiply(
                        monthlyInterestRate.add(
                                monthlyInterestRate.divide(
                                        monthlyInterestRate
                                                .add(BigDecimal.ONE)
                                                .pow(term)
                                                .subtract(BigDecimal.ONE), 8, RoundingMode.CEILING
                                )
                        )
                ).setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal getMonthlyInterestRate(BigDecimal currentRate) {

        return currentRate.divide(BigDecimal.valueOf(100), 8, RoundingMode.CEILING)
                .divide(BigDecimal.valueOf(12), 8, RoundingMode.CEILING);
    }
}
