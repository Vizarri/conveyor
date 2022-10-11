package com.vizarri.conveyor.DTO;

import com.vizarri.conveyor.enums.Gender;
import com.vizarri.conveyor.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoringDataDTO {
    BigDecimal amount;
    Integer term;
    String firstName;
    String lastName;
    String middleName;
    Enum<Gender> gender;
    LocalDate birthdate;
    String passportSeries;
    String passportNumber;
    LocalDate passportIssueDate;
    String passportIssueBranch;
    Enum<MaritalStatus> maritalStatus;
    Integer dependentAmount;
    EmploymentDTO employment;
    String account;
    Boolean isInsuranceEnabled;
    Boolean isSalaryClient;
}
