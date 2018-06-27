package com.lsieben.vnes.lang.exceptions;

import com.lsieben.vnes.logger.Message;

public class vNESCompilerException extends Exception {
    private String code;
    private String message;
    private String location;

    public final String newLine = System.lineSeparator();

    public vNESCompilerException(String... arguments) {
        message = getMessage();
        code = getCode();
        for(int i = 1; i < arguments.length + 1; i++) {
            message = message.replace("$" + String.valueOf(i), arguments[i - 1]);
        }
    }

    public String getMessage() {
        return "Unknown error";
    }

    public String getCode() {
        return "-1";
    }


    public Message toMessage() {
        Message msg = new Message(message);
        msg.setSeverity("warning");
        msg.setCode(code);
        msg.setLocation(location);
        return msg;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
