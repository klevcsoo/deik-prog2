package zhproba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// roszpapakrisztian@gmail.com

public class Main {

    public static void main(String[] args) {
        List<Parcella> parcellaList;
        try {
            parcellaList = inputParcellak();
        } catch (NumberFormatException | IOException e) {
            System.out.println(e.getLocalizedMessage());
            return;
        }

        System.out.println("Termelési adatok felvétele");
        for (var p : parcellaList) {
            System.out.println(p);
            try {
                inputTermeles(p);
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
                continue;
            }
        }

        for (var p : parcellaList) {
            System.out.println(p);
        }
    }

    private static List<Parcella> inputParcellak() throws NumberFormatException, IOException {
        List<Parcella> parcellaList = new ArrayList<>();

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("---- ÚJ PARCELLA FELVÉTELE ----");

            System.out.println("A parcella helyrajzi száma:");
            int hsz = Integer.parseInt(br.readLine());

            System.out.println("A szőlő fajtája:");
            for (int i = 0; i < SzoloFajta.values().length; i++) {
                System.out.println(String.format("%s: %s",
                        i + 1, SzoloFajta.values()[i]));
            }
            SzoloFajta szf = SzoloFajta.valueOf(Integer.parseInt(br.readLine())).orElse(null);
            if (szf == null) {
                System.out.println("Hiba: Érvénytelen szőlő fajta\n\n");
                return inputParcellak();
            }

            System.out.println("A parcella tőkeszáma:");
            int tsz = Integer.parseInt(br.readLine());

            parcellaList.add(new Parcella(hsz, szf, tsz));

            System.out.println("Szeretnél még felvinni parcellát? (i / n)");
            if (br.readLine().equalsIgnoreCase("n")) {
                System.out.println("Megszakítás...");
                break;
            }
        }

        return parcellaList;
    }

    private static void inputTermeles(Parcella parcella) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            System.out.println("---- ÚJ TERMELÉSI ADAT FELVÉTELE ----");

            System.out.println("Év:");
            int ev = Integer.parseInt(br.readLine());
            if (parcella.getEvesTermesek().stream().map(t -> {
                return t.getEv();
            }).toList().contains(ev)) {
                System.out.println("Erre az évre már van felvéve adat.");
                continue;
            }

            System.out.println("Össztermés:");
            int osszTermes = Integer.parseInt(br.readLine());

            parcella.evesTermesFelvetele(ev, osszTermes);

            System.out.println("Szeretnél még felvinni termelési adatot? (i / n)");
            if (br.readLine().equalsIgnoreCase("n")) {
                System.out.println("Megszakítás...");
                break;
            }
        }
    }
}
