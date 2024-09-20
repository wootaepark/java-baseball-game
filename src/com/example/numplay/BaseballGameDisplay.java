package com.example.numplay;

import java.util.Iterator;
import java.util.List;

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

    public static void displayHistory(List<Integer> history){


        System.out.println("<게임 기록 보기>");
        if(history.isEmpty()){
            System.out.println("기록이 존재하지 않습니다.\n");
        }
        else{
            int start = 1;
            for (Integer integer : history) {
                System.out.println(start++ + "번째 게임 : 시도 횟수 -  " + integer);
            }
            System.out.println();
        }
    }
}
