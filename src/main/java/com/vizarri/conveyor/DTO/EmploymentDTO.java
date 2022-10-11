package com.vizarri.conveyor.DTO;

import com.vizarri.conveyor.enums.EmploymentStatus;
import com.vizarri.conveyor.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentDTO {
    Enum<EmploymentStatus> employmentStatus;
    String employerINN;
    BigDecimal salary;
    Enum<Position> position;
    Integer workExperienceTotal;
    Integer workExperienceCurrent;
}
