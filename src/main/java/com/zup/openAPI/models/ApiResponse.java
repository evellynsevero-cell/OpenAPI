package com.zup.openAPI.models;


public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private String error;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;

    }

}
