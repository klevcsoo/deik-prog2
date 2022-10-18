package verseny.teszt;

import verseny.Csapat;
import verseny.Egyeni;
import verseny.Verseny;
import verseny.Versenyzo;
import verseny.dalverseny.XFaktor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VersenyTeszt {
    private static final String DEBUG_DATA_PATH = "src/verseny/teszt/data.txt";

    public static void main(String[] args) {
        // if (args.length < 1) {
        //     System.out.println("Hiba: Nincs bemeneti fájl");
        //     return;
        // }

        // File dataFile = new File(args[0]);
        File dataFile = new File(DEBUG_DATA_PATH);
        if (!dataFile.exists()) {
            System.out.println("Hiba: Megadott bementi fájl nem létezik");
            return;
        }

        Scanner scanner;
        try {
            scanner = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: Megadott bementi fájl nem létezik");
            return;
        }

        List<Versenyzo> versenyzoList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] rawList = scanner.nextLine().split(";");
            int azon = Integer.parseInt(rawList[1]);
            String nev = rawList[2];
            String terulet = rawList[3];

            if (rawList[0].equals("E")) {
                versenyzoList.add(new Egyeni(
                        azon, nev, terulet, Integer.parseInt(rawList[4])
                ));
            } else if (rawList[0].equals("C")) {
                String[] tagok = rawList[4].split("/");
                versenyzoList.add(new Csapat(
                        azon, nev, terulet, Arrays.asList(tagok)
                ));
            } else {
                System.out.println("Hiba: Érvénytelen adat a megadott bemeneti fájlban");
                return;
            }
        }

        XFaktor xFaktor = new XFaktor(
                args.length < 2 ? 2018 : Integer.parseInt(args[1]),
                new ArrayList<>(versenyzoList.stream().filter(versenyzo -> {
                    return versenyzo.getTerulet().equals("ének");
                }).toList())
        );

        System.out.println("Melyik versenyző lépjen vissza? (azonosító)");
        int azonToLepjenVissza = new Scanner(System.in).nextInt();
        if (!xFaktor.visszalep(azonToLepjenVissza)) {
            System.out.println("A versenyző nem volt nevezve. Nem történt változás");
        }

        System.out.println(xFaktor);

        System.out.println("Melyik fájlba legyen exportálva? (útvonal)");
        String exportUtvonal = new Scanner(System.in).nextLine();
        List<Verseny> exportList = new ArrayList<>();
        exportList.add(xFaktor);
        try {
            kiirasAllomanyba(exportList, exportUtvonal);
        } catch (IOException e) {
            System.out.println("IO Hiba");
            System.out.println(e.getMessage());
        }
    }

    private static void kiirasAllomanyba(List<Verseny> versenyList, String utvonal)
            throws IOException {
        for (var v : versenyList) {
            int[] versenyzoCount = v.versenyzokSzama();
            if (versenyzoCount[1] <= versenyzoCount[0]) continue;

            Files.writeString(Paths.get(utvonal), v.toString(), StandardCharsets.UTF_8);
        }
    }
}
