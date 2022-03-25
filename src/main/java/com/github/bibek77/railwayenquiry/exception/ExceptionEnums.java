package com.github.bibek77.railwayenquiry.exception;

import lombok.Getter;

/**
 * @author bibek
 */
@Getter
public enum ExceptionEnums {
    DataNotFound("data.not.found", "Data is not Present in the Railway System"),
    InternalServerError("internal.server.error", "Internal Server Error Occurred");

    private String message;
    private String description;

    ExceptionEnums(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
