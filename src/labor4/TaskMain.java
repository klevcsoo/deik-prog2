package labor4;

import labor4.mikulas.Ajandek;
import labor4.mikulas.GyerekJatek;
import labor4.mikulas.Puttony;

import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {
        var a1 = new Ajandek("Nyakkendő", 0.1, 3400);
        var a2 = new Ajandek("Nyakkendő", 0.2, 4400);
        System.out.println(a1.equals(a2));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Syntax: ajándék_neve tömege ára");

        Puttony puttony = new Puttony();

        for (int i = 0; i < 5; i++) {
            String[] raw = scanner.nextLine().split(" ");

            if (raw.length < 3) {
                System.out.println("Hiányzó elemek");
                i--;
                continue;
            }

            double weight = Double.parseDouble(raw[1]);
            int price = Integer.parseInt(raw[2]);

            if (raw.length > 3) {
                int minAge = Integer.parseInt(raw[3]);
                puttony.ajandekok.add(new GyerekJatek(
                        raw[0], weight, price, minAge
                ));
            } else {
                puttony.ajandekok.add(new Ajandek(
                        raw[0], weight, price
                ));
            }
        }

        System.out.println(puttony.ajandekok);
    }
}
