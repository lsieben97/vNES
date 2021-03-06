package com.lsieben.retroscript.lang.exceptions.errors;

import com.lsieben.retroscript.lang.exceptions.RetroScriptCompilerException;

public class ReferenceNotFoundException extends RetroScriptCompilerException {

    public ReferenceNotFoundException(String location, String... arguments) {
        super(location, arguments);
    }

    @Override
    public String getErrorMessage() {
        return "Could not find $1 '$2'. Did you forget a USE statement?";
    }

    @Override
    public String getCode() {
        return "002";
    }
}
