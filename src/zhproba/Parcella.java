package zhproba;

import java.util.ArrayList;
import java.util.List;

public class Parcella {

    private final int helyrajziSzam;
    private SzoloFajta szoloFajta;
    private int tokeszam;
    private List<EvesTermes> evesTermesek;

    public Parcella(int helyrajziSzam, SzoloFajta szoloFajta, int tokeszam) {
        this.helyrajziSzam = helyrajziSzam;
        this.szoloFajta = szoloFajta;
        this.tokeszam = tokeszam;
        this.evesTermesek = new ArrayList<>();
    }

    public void evesTermesFelvetele(int ev, int osszTermes) {
        this.evesTermesek.add(new EvesTermes(ev, osszTermes, this.tokeszam));
    }

    public void evesTermesFrissitese(int ev, int összTermes) {
        for (var t : this.evesTermesek) {
            if (t.getEv() == ev) {
                t.termesFrissitese(összTermes, this.tokeszam);
                break;
            }
        }

        System.out.println("Hiba: Keresett évi termés nem található.");
    }

    public int getHelyrajziSzam() {
        return helyrajziSzam;
    }

    public SzoloFajta getSzoloFajta() {
        return szoloFajta;
    }

    public int getTokeszam() {
        return tokeszam;
    }

    public List<EvesTermes> getEvesTermesek() {
        return evesTermesek;
    }

    public void setSzoloFajta(SzoloFajta szoloFajta) {
        this.szoloFajta = szoloFajta;
    }

    public void setTokeszam(int tokeszam) {
        this.tokeszam = tokeszam;
    }

    @Override
    public String toString() {
        return String.format(
                "Parcella [helyrajziSzam=%s, szoloFajta=%s, tokeszam=%s, evesTermesek=%s]",
                helyrajziSzam, szoloFajta, tokeszam, evesTermesek);
    }

}
