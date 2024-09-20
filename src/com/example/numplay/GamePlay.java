package com.example.numplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GamePlay { // 게임 플레이를 위한 기본 설정 및 출력 클래스

    private Set<Integer> pitch; // 유저가 입력한 정보
    private List<Integer> answer; // 정답 정보
    private int digits, strike, ball, game_count;


    public GamePlay(int digits) { // 초기 세팅
        this.digits = digits;
        pitch = new HashSet<>(); // input 관리
        answer = new ArrayList<>(); // 정답 관리

        this.game_count = 0; // 게임 시도 횟수 초기화
    }

    public void makeRandomNumber(int digits) {
        Set<Integer> tempSet = new HashSet<>();

        while (tempSet.size() < digits) {
            tempSet.add((int) (Math.random() * 9 + 1)); // 자릿수 만족 시 까지 랜덤 정수 입력
        }

        answer.addAll(tempSet);
        //System.out.println(answer.toString());
        Collections.shuffle(answer);
        //System.out.println(answer.toString());

    }

    // 실질적인 게임 플레이 코드
    public int play() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeRandomNumber(3);

        while (true) {
            try {
                System.out.println("숫자를 입력하세요");
                String input = br.readLine();


                if (input.length() != digits) {
                    throw new CustomInputMismatchException();
                }


                for (int i = 0; i < digits; i++) {
                    char c = input.charAt(i);
                    if (!Character.isDigit(c) || c-'0'== 0) { // 숫자가 아닌 값이 또는 0이 들어온 경우
                        throw new CustomInputMismatchException();
                    }
                    pitch.add(Character.getNumericValue(c));
                }
                //System.out.println("입력된 숫자:" + pitch);


                if (pitch.size() != digits) { // 저장된 자리수가 다른 경우 아래 예외 발생시키기 (중복의 경우)
                    throw new CustomInputMismatchException();
                }
                //System.out.println(input);
                strike = countStrike(input);

                if(strike == digits) {
                    System.out.println("정답입니다!\n");
                    break; // 정답인 경우
                }

                ball = countBall(input);
                BaseballGameDisplay.displayHint(strike,ball);
                System.out.println("\n");
                pitch.clear();
                game_count++; // 올바른 형식이 입력된 경우


            } catch (CustomInputMismatchException e) {
                System.out.println(e.getMessage());
                pitch.clear();// 올바른 입력을 받기 위해 초기화
            }


        }

        return game_count;
    }



    // 스트라이크 판단 코드
    private int countStrike(String input) {
        int strike = 0;
        for (int i = 0; i < digits; i++) {
            if (Character.getNumericValue(input.charAt(i)) == answer.get(i)) {
                strike++;
                // 입력값에서 i번째 숫자와 정답에서 i번째 숫자가 같으면 스트라이크
            }
        }
        return strike;
    }

    // 볼 판단 코드
    private int countBall(String input) {
        int ball = 0;
        for (int i = 0; i < digits; i++) {
            int num = Character.getNumericValue(input.charAt(i));
            // 스트라이크는 아니면서, 입력값이 정답에 포함되어 있으면 볼
            if (answer.contains(num) && num != answer.get(i)) {
                ball++;
            }
        }
        return ball;

    }


}
