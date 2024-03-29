package com.vizarri.conveyor.exceptionHandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ConveyorException extends RuntimeException {
    private String info;
}
