package com.vizarri.conveyor.service;

import com.vizarri.conveyor.DTO.LoanApplicationRequestDTO;
import com.vizarri.conveyor.DTO.LoanOfferDTO;
import com.vizarri.conveyor.exceptionHandler.ConveyorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
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
/*
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), basicRate.add(BigDecimal.valueOf(1L))))
                        .rate(basicRate.add(BigDecimal.valueOf(0.02D)))
                        .isInsuranceEnabled(true)
                        .isSalaryClient(true)
                        .build());
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), basicRate.subtract(BigDecimal.valueOf(2L))))
                        .rate(basicRate.subtract(BigDecimal.valueOf(0.02D)))
                        .isInsuranceEnabled(false)
                        .isSalaryClient(false)
                        .build());
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), basicRate.subtract(BigDecimal.valueOf(1L))))
                        .rate(basicRate.subtract(BigDecimal.valueOf(0.01D)))
                        .isInsuranceEnabled(true)
                        .isSalaryClient(false)
                        .build());
*/
        possibleLoanTerms.add(
                LoanOfferDTO.builder()
                        .requestedAmount(loanApplicationRequestDTO.getAmount())
                        .totalAmount(loanApplicationRequestDTO.getAmount())
                        .term(loanApplicationRequestDTO.getTerm())
                        .monthlyPayment(countMonthlyPayment(loanApplicationRequestDTO.getTerm(), loanApplicationRequestDTO.getAmount(), basicRate))
                        .rate(basicRate)
                        .isInsuranceEnabled(false)
                        .isSalaryClient(true)
                        .build());
        return possibleLoanTerms;
    }

    private BigDecimal countMonthlyPayment(Integer term, BigDecimal requestedAmount, BigDecimal basicRate) {
        System.out.println(term);
        System.out.println(requestedAmount);
        System.out.println(basicRate);
        double a = basicRate.doubleValue() / 12D / 100D;
        BigDecimal rateInMonth = BigDecimal.valueOf(basicRate.doubleValue() / 12D / 100D);
        BigDecimal monthlyPayment = rateInMonth.multiply(rateInMonth.add(BigDecimal.valueOf(1D))).pow(term).divide((BigDecimal.valueOf(1D).add(rateInMonth)).pow(term).subtract(BigDecimal.valueOf(1D)), RoundingMode.HALF_UP);
        return monthlyPayment.setScale(3, RoundingMode.HALF_UP);
    }
}
