package com.blogging.articles.Exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String detials;

    public ErrorDetails(LocalDateTime timeStamp, String message, String detials) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detials = detials;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetials() {
        return detials;
    }
}
