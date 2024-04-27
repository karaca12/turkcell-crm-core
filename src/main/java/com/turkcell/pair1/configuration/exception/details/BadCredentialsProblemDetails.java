package com.turkcell.pair1.configuration.exception.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadCredentialsProblemDetails extends ProblemDetails{
    public BadCredentialsProblemDetails() {
        setType("https://turkcell.com/exceptions/business");
        setTitle("Business Rule Violation");
    }
}
