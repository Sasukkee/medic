package com.example.analysys;

public class SendCodeResponse {
    public SendCodeResponse(String message) {
        this.message = message;
    }

    static public String getMessage() {
        return message;
    }

    static String message;

}
