package com.example.numplay;

public class BaseballGameDisplay {
    public static void displayHint(int strike, int ball) {

        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }

        if (ball > 0) {
            System.out.print(ball + "볼");
        }

        if(strike == 0 && ball == 0) {
            System.out.println("아웃");
        }


    }
}
