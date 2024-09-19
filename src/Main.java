import com.example.numplay.GamePlay;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("< 게임을 시작합니다 >");
        GamePlay gp = new GamePlay(3);
        gp.play();

    }
}