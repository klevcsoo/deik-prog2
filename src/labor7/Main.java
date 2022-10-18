package labor7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Tom", 28, 10);
        Player player2 = new Player("David", 30, 16);
        Player player3 = new Player("Ben", 30, 8);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        System.out.println(playerList);
        Collections.sort(playerList);
        System.out.println(playerList);
    }
}
