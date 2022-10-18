package verseny.dalverseny;

import verseny.Csapat;
import verseny.Egyeni;
import verseny.Verseny;
import verseny.Versenyzo;

import java.util.*;

public class XFaktor implements Verseny {
    private int evad;
    private ArrayList<Versenyzo> versenyzok = new ArrayList<>();

    public XFaktor(int evad, ArrayList<Versenyzo> versenyzok) {
        this.evad = evad;
        this.versenyzok = versenyzok;
    }

    @Override
    public void nevez(Versenyzo versenyzo) {
        boolean exists = this.versenyzok.stream()
                .map(Versenyzo::getAzonosito).toList()
                .contains(versenyzo.getAzonosito());
        if (!exists) this.versenyzok.add(versenyzo);
    }

    @Override
    public boolean visszalep(int azonosito) {
        return this.versenyzok.removeIf(versenyzo -> versenyzo.getAzonosito() == azonosito);
    }

    @Override
    public int[] versenyzokSzama() {
        int[] out = new int[2];

        out[0] = this.versenyzok.stream().filter(versenyzo -> {
            return versenyzo instanceof Egyeni;
        }).toList().size();
        out[1] = this.versenyzok.stream().filter(versenyzo -> {
            return versenyzo instanceof Csapat;
        }).toList().size();

        return out;
    }

    @Override
    public String toString() {
        Collections.sort(this.versenyzok);
        StringBuilder stringBuilder = new StringBuilder();
        for (var v : this.versenyzok) stringBuilder.append(v.toString()).append("\n");
        return "X-Faktor - %s\n%s".formatted(
                this.evad, stringBuilder.toString()
        );
    }
}
