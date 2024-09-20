import com.example.numplay.BaseballGameDisplay;
import com.example.numplay.GamePlay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br;
        List<Integer> try_count = new ArrayList<>();

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("1.게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            br = new BufferedReader(new InputStreamReader(System.in));
            int menu = Integer.parseInt(br.readLine());
            if (menu == 1) {
                System.out.println("< 게임을 시작합니다 >");
                GamePlay gp = new GamePlay(3);
                try_count.add(gp.play());
            } else if (menu == 2) {
                BaseballGameDisplay.displayHistory(try_count);

            } else if (menu == 3) {
                System.out.println("숫자 야구를 모두 종료합니다.");
                break;
            }
            else{
                System.out.println("올바른 숫자를 입력해주세요!\n");
            }
        }


    }
}