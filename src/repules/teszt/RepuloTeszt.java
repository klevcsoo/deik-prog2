package repules.teszt;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Scanner;

import repules.Flotta;
import repules.Repulogep;
import repules.Utasszallito;
import repules.legikozlekedes.LegiTarsasag;

public class RepuloTeszt {

    public static void main(String[] args) {
        if (/* args.length < 1 */ false) {
            System.out.println("Hiba: Hiányzó bemeneti fájl");
            return;
        }
        String filepath = /* args[0]; */ "/Users/klevcsoo/Developer/deik-prog2/src/repules/data.txt";

        List<Repulogep> repulogepList;
        try {
            repulogepList = readDataFile(filepath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        LegiTarsasag legiTarsasag = new LegiTarsasag(
                args.length < 2 ? "Unideb Airlines" : args[1],
                repulogepList.toArray(new Repulogep[repulogepList.size()]));

        printUtasszallitoList(legiTarsasag);

        System.out.println("Adj meg egy gyártót:");
        Scanner gyScanner = new Scanner(System.in);
        String gy = /* gyScanner.nextLine(); */ "Boeing";
        gyScanner.close();
        feladat8(repulogepList, gy);

        legiTarsasag.feladat9();

        feladat10(new LegiTarsasag[] { legiTarsasag });
        feladat11(new LegiTarsasag[] { legiTarsasag }, 20);
    }

    private static List<Repulogep> readDataFile(String filepath)
            throws IOException, InvalidPropertiesFormatException {
        Scanner scanner = new Scanner(Paths.get(filepath));
        List<Repulogep> out = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] raw = scanner.nextLine().split(";");
            if (raw.length < 5) {
                throw new InvalidPropertiesFormatException(
                        "Hiba: Helytelen formátum az adatfájlban");
            }

            Repulogep r = new Repulogep(raw[1], raw[2],
                    Double.parseDouble(raw[3].replace(",", ".")),
                    raw[4] == "S");
            if (raw[0].charAt(0) == 'U') {
                if (raw.length < 6) {
                    throw new InvalidPropertiesFormatException(
                            "Hiba: Helytelen formátum az adatfájlban");
                }

                out.add(new Utasszallito(
                        raw[1], raw[2],
                        Double.parseDouble(raw[3].replace(",", ".")),
                        raw[4] == "S", Integer.parseInt(raw[5])));
            } else {
                out.add(r);
            }
        }

        scanner.close();
        return out;
    }

    private static void printUtasszallitoList(LegiTarsasag tarsasag) {
        System.out.println("Minimum férőhely:");
        Scanner scanner = new Scanner(System.in);
        int f = /* scanner.nextInt() */ 70;
        System.out.println(tarsasag.megfeleloGepek(f));
        scanner.close();
    }

    private static void feladat8(List<Repulogep> repulogepek, String gyarto) {
        for (var r : repulogepek) {
            if (r.getGyarto().equalsIgnoreCase(gyarto)) {
                System.out.println(String.format("%s %s",
                        r instanceof Utasszallito ? "Utasszállitó:" : "Egyszerű:", r));
            }
        }
    }

    private static void feladat10(Flotta[] flottak) {
        for (int i = 0; i < flottak.length; i++) {
            flottak[i].kiir(String.format("lista%s.txt", i + 1));
        }
    }

    private static void feladat11(LegiTarsasag[] tarsasagok, int darab) {
        List<String> changed = new ArrayList<>();
        for (var t : tarsasagok) {
            List<Repulogep> temp = t.getRepulogepList();
            for (int i = 0; i < temp.size(); i++) {
                boolean eligible = temp.get(i).getGyarto()
                        .equalsIgnoreCase("Airbus") &&
                        temp.get(i) instanceof Utasszallito;

                if (eligible) {
                    ((Utasszallito) temp.get(i)).setFerohely(
                            ((Utasszallito) temp.get(i)).getFerohely() + darab);

                    if (!changed.contains(t.getNev()))
                        changed.add(t.getNev());
                }
            }
            t.setRepulogepList(temp);
        }

        System.out.println(String.join("\n", changed));
    }
}
