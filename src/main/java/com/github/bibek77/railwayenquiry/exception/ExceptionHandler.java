package com.github.bibek77.railwayenquiry.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bibek
 */
@Getter
@Setter
@ResponseStatus
public class ExceptionHandler extends RuntimeException {
    private String message;
    private String description;

    public ExceptionHandler(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
