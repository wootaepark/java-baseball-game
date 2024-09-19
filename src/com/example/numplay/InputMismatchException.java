package com.example.numplay;

public class InputMismatchException extends Exception {
    public InputMismatchException() {
        super("입력 형식이 일치하지 않습니다.");
    }
}
