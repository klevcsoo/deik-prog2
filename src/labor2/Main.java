package labor2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "Ford"};
        //noinspection unused
        int[] numbers = {12, 25, 2};

        //noinspection ForLoopReplaceableByForEach
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        List<String> games = new ArrayList<>();
        games.add("LOL");
        games.add("WOW");

        for (var game : games) {
            System.out.println(game);
        }

        Map<String, Integer> points = new HashMap<>();
        points.put("Tom", 15);
        points.put("David", 5);

        for (Map.Entry<String, Integer> entry : points.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
