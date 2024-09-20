package com.example.numplay;

public class CustomInputMismatchException extends Exception {
    public CustomInputMismatchException() {
        super("올바르지 않은 입력값입니다\n");
    }
}
