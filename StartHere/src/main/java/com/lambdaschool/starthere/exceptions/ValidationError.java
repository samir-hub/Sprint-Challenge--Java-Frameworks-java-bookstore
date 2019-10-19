package com.lambdaschool.starthere.exceptions;

public class ValidationError
{
    private String Code;
    private String message;

    public ValidationError()
    {
    }

    public ValidationError(String code, String message)
    {
        Code = code;
        this.message = message;
    }

    public String getCode()
    {
        return Code;
    }

    public void setCode(String code)
    {
        Code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "ValidationError{" + "Code='" + Code + '\'' + ", message='" + message + '\'' + '}';
    }
}
