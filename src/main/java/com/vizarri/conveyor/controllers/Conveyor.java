package com.vizarri.conveyor.controllers;

import com.vizarri.conveyor.DTO.CreditDTO;
import com.vizarri.conveyor.DTO.LoanApplicationRequestDTO;
import com.vizarri.conveyor.DTO.LoanOfferDTO;
import com.vizarri.conveyor.DTO.ScoringDataDTO;
import com.vizarri.conveyor.service.CounterPossibleLoanTerms;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class Conveyor {
    CounterPossibleLoanTerms counterPossibleLoanTerms;

    @PostMapping("/conveyor/offers")
    public List<LoanOfferDTO> calculatePossibleLoanTerms(@RequestBody @Valid LoanApplicationRequestDTO loanApplicationRequestDTO) {
        log.info("loanApplicationRequestDTO in calculatePossibleLoanTerms {}", loanApplicationRequestDTO);
        return counterPossibleLoanTerms.getPossibleLoanTerms(loanApplicationRequestDTO);
    }

    @PostMapping("/conveyor/calculation")
    public CreditDTO dataCalculation(@RequestBody @Valid ScoringDataDTO scoringDataDTO) {
        return null;
    }

}
