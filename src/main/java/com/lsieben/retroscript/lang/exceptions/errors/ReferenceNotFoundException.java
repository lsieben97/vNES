package com.lsieben.retroscript.lang.exceptions.errors;

import com.lsieben.retroscript.lang.exceptions.vNESCompilerException;

public class ReferenceNotFoundException extends vNESCompilerException {

    public ReferenceNotFoundException(String location, String... arguments) {
        super(location, arguments);
    }

    @Override
    public String getMessage() {
        return "Could not find $1 '$2'. Did you forget a USE statement?";
    }

    @Override
    public String getCode() {
        return "002";
    }
}