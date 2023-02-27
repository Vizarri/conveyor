package com.vizarri.conveyor.service;

import com.vizarri.conveyor.DTO.LoanApplicationRequestDTO;
import com.vizarri.conveyor.DTO.LoanOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class counterPossibleLoanTerms {
    @Autowired
    private Environment env;
    List<LoanOfferDTO> possibleLoanTerms;

    public List<LoanOfferDTO> getPossibleLoanTerms(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        LoanOfferDTO.builder()
                .requestedAmount(loanApplicationRequestDTO.getAmount())
                .totalAmount(loanApplicationRequestDTO.getAmount())
                .term(loanApplicationRequestDTO.getTerm())
                .monthlyPayment(BigDecimal.valueOf(loanApplicationRequestDTO.getTerm() / (loanApplicationRequestDTO.getTerm() * 12)) +
                        BigDecimal.valueOf(loanApplicationRequestDTO.getTerm() / (loanApplicationRequestDTO.getTerm() * 12)) *
                                BigDecimal.valueOf(env.getProperty("basic.rate")))
                .

        this.possibleLoanTerms.add
    }
}
