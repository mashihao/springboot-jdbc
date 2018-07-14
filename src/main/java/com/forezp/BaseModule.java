package com.forezp;

import java.io.Serializable;

/**
 * TODO
 * @author msh
 * @time 2017/11/23 20:55
 */
public class BaseModule<T> implements Serializable {

    private boolean IsSuccess = false;
    private int ErrorCode = 0;
    private String Message = "";
    private T Result;

    public boolean isIsSuccess() {
        return IsSuccess;
    }

    public void setIsSuccess(boolean IsSuccess) {
        this.IsSuccess = IsSuccess;
    }

    public int getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getResult() {
        return Result;
    }

    public void setResult(T result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "BaseModule{" +
                "IsSuccess=" + IsSuccess +
                ", ErrorCode=" + ErrorCode +
                ", Message='" + Message + '\'' +
                ", Result=" + Result +
                '}';
    }
}
