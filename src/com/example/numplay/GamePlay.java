package com.example.numplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.InputMismatchException;

public class GamePlay { // 게임 플레이를 위한 기본 설정 및 출력 클래스

    private Set<Integer> pitch;
    private int digits, strike, ball, out;


    public GamePlay(int digits) { // 초기 세팅
        this.digits = digits;
        pitch = new HashSet<>();

        this.strike = 0;
        this.ball = 0;
        this.out = 0;
    }

    public void play() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("\n숫자를 입력하세요");

                String input = br.readLine();

                if(input.length() != digits){
                    throw new CustomInputMismatchException();
                }

                for (int i = 0; i < digits; i++) {
                    char c = input.charAt(i);
                    if(!Character.isDigit(c)){ // 숫자가 아닌 값이 들어온 경우
                        throw new CustomInputMismatchException();
                    }
                    pitch.add(Character.getNumericValue(c));
                }
                System.out.println("입력된 숫자:" + pitch);


                if (pitch.size() != digits) { // 저장된 자리수가 다른 경우 아래 예외 발생시키기 (중복의 경우)
                    throw new CustomInputMismatchException();
                }

                System.out.println(input);
                pitch.clear();// 올바른 입력을 받기 위해 초기화
                break;

            } catch (CustomInputMismatchException e) {
                System.out.println(e.getMessage());
            }


        }


    }


}
