package kartografia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Hiba: hiányzó bemeneti fájl útvonal");
//            return;
//        }
        final String TESTARG = "src/kartografia/data.txt";

        Scanner scanner;
        try {
            scanner = new Scanner(new File(TESTARG));
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: megadott bemeneti fájl nem található");
            return;
        }

        List<Terkep> terkepek = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] raw = scanner.nextLine().split(";");
            System.out.println(Arrays.toString(raw));

            String cim = raw[0];
            int arany = Integer.parseInt(raw[1].split(":")[1]);

            if (raw.length > 2) {
                String[] nevek = raw[2].split(":");

                if (raw.length > 3) {
                    String tema = raw[3];
                    terkepek.add(new TematikusTerkep(
                            cim, arany, Arrays.stream(nevek).toList(), tema
                    ));
                } else {
                    terkepek.add(new Terkep(cim, arany, Arrays.stream(nevek).toList()));
                }
            } else {
                terkepek.add(new Terkep(cim, arany, new ArrayList<>()));
            }
        }

        Atlasz atlasz = new Atlasz(terkepek, "Nagyszerű atlasz");
        System.out.println(atlasz);
    }
}
