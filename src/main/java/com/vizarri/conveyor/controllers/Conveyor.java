package com.vizarri.conveyor.controllers;

import com.vizarri.conveyor.DTO.CreditDTO;
import com.vizarri.conveyor.DTO.LoanApplicationRequestDTO;
import com.vizarri.conveyor.DTO.LoanOfferDTO;
import com.vizarri.conveyor.DTO.ScoringDataDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Conveyor {
    @PostMapping("/conveyor/offers")
    public List<LoanOfferDTO> calculatePossibleLoanTerms(LoanApplicationRequestDTO loanApplicationRequestDTO) {
    return null;
    }
    @PostMapping("/conveyor/calculation")
    public CreditDTO dataCalculation (ScoringDataDTO scoringDataDTO){
    return null;
    }

}
