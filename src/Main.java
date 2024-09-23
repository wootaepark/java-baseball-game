import com.example.numplay.BaseballGameDisplay;
import com.example.numplay.GamePlay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc;
        int digits = 3; // 디폴트 3
        List<Integer> try_count = new ArrayList<>();


        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1.게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            sc = new Scanner(System.in);
            int menu = sc.nextInt();

            if (menu == 0) {
                while (true) {
                    try {
                        System.out.println("설정하고자 하는 자리수를 입력하세요");
                        digits = sc.nextInt();


                        if (digits >= 3 && digits <= 5) {
                            System.out.println(digits + "자리수 난이도로 설정되었습니다.\n");
                            menu = 1;
                            break;
                        }
                        System.out.println("3이상 5이하의 정수를 입력하세요\n");


                    }catch (InputMismatchException e){
                        System.out.println("올바른 형태의 정수를 입력해주세요\n");
                        sc.nextLine();
                    }


                }

            }

            if (menu == 1) {
                System.out.println("< 게임을 시작합니다 >");
                GamePlay gp = new GamePlay(digits);
                try_count.add(gp.play());
            } else if (menu == 2) {
                BaseballGameDisplay.displayHistory(try_count);

            } else if (menu == 3) {
                System.out.println("숫자 야구를 모두 종료합니다.");
                break;
            } else {
                System.out.println("올바른 숫자를 입력해주세요!\n");
            }
        }


    }
}