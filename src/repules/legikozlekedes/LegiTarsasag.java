package repules.legikozlekedes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import repules.Flotta;
import repules.Repulogep;
import repules.Utasszallito;

public class LegiTarsasag implements Flotta {

    private String nev;
    private List<Repulogep> repulogepList;

    public LegiTarsasag(String nev, Repulogep[] repulogepek) {
        this.nev = nev;
        this.repulogepList = new ArrayList<>();

        for (var r : repulogepek)
            this.repulogepList.add(r);
    }

    @Override
    public void felvesz(Repulogep repulo) {
        this.repulogepList.add(repulo);
    }

    @Override
    public List<Utasszallito> megfeleloGepek(int utasszam) {
        return this.repulogepList.stream().filter(r -> {
            if (!(r instanceof Utasszallito)) {
                return false;
            } else
                return ((Utasszallito) r).getFerohely() >= utasszam;
        }).map(r -> ((Utasszallito) r)).toList();
    }

    @Override
    public void kiir(String fajlnev) {
        Path file = Paths.get(fajlnev);
        List<String> lines = new ArrayList<>();
        lines.add(this.nev);
        for (var r : this.repulogepList)
            lines.add(r.toString());

        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Hiba történt a repülőgépek fájlba kiírásakor.");
            e.printStackTrace();
        }
    }

    public void feladat9() {
        for (var r : this.repulogepList) {
            if (!(r instanceof Utasszallito) && this.repulogepList.stream().filter(t -> {
                return t.getGyarto().equalsIgnoreCase(r.getGyarto());
            }).allMatch(t -> !(t instanceof Utasszallito))) {
                System.out.println(r);
            }
        }
    }

    public List<Repulogep> getRepulogepList() {
        return repulogepList;
    }

    public void setRepulogepList(List<Repulogep> repulogepList) {
        this.repulogepList = repulogepList;
    }

    public String getNev() {
        return nev;
    }
}
