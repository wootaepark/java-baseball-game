package com.example.numplay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GamePlay { // 게임 플레이를 위한 기본 설정 및 출력 클래스

    private int digits, strike, ball, out; 
    // 자릿수, 스트라이크 카운트, 볼 카운트, 아웃 카운트
    // GamePlay 가 새로 생성될때마다 각 올바른 값으로 초기화 되어야 한다.

    public GamePlay(){
        this(3); // 기본 생성자로 세자리 입력 받로고 함
    }
    public GamePlay(int digits){
        this.digits = digits;
        this.strike = 0;
        this.ball = 0;
        this.out = 0;
    }

    public void play() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        Scanner sc = new Scanner(System.in);

        try{
            while(true){
                System.out.println("< 게임을 시작합니다 >");
                System.out.println("숫자를 입력하세요");




            }

        }catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }



        sc.close();
    }

    


}
