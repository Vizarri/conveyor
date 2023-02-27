package com.vizarri.conveyor.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplicationRequestDTO {
    @Min(value = 1)
    BigDecimal amount;
    @Min(value = 6)
    Integer term;
    @Pattern(regexp = "[A-Za-z]{2,30}")
    String firstName;
    @Pattern(regexp = "[A-Za-z]{2,30}")
    String lastName;
    @Pattern(regexp = "[A-Za-z]{2,30}")
    String middleName;
    @Pattern(regexp = "[\\w.]{2,50}@[\\w.]{2,20}")
    String email;
    LocalDate birthdate;
    @Size(min = 4, max = 4)
    String passportSeries;
    @Size(min = 6, max = 6)
    String passportNumber;
}
