package com.turkcell.pair1.configuration.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeignProblemDetails extends ProblemDetails {
    public FeignProblemDetails() {
        setTitle("Feign Exception");
        setType("https://turkcell.com/exceptions/feign");
    }
}
