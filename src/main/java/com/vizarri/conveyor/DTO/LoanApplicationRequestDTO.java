package com.vizarri.conveyor.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoanApplicationRequestDTO {
    @NotNull
    @Min(value = 1)
    BigDecimal amount;

    @NotNull
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthdate;
    @Size(min = 4, max = 4)
    String passportSeries;
    @Size(min = 6, max = 6)
    String passportNumber;
}
