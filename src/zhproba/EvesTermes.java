package zhproba;

public class EvesTermes {

    private int ev;
    private int osszTermes;
    private double atlag;

    public EvesTermes(int ev, int osszTermes, int tokeszam) {
        this.ev = ev;
        this.osszTermes = osszTermes;
        this.atlagSzamitas(tokeszam);
    }

    private void atlagSzamitas(int tokeszam) {
        this.atlag = ((double) this.osszTermes) / ((double) tokeszam);
    }

    public void termesFrissitese(int osszTermes, int tokeszam) {
        this.osszTermes = osszTermes;
        this.atlagSzamitas(tokeszam);
    }

    public int getEv() {
        return ev;
    }

    public int getOsszTermes() {
        return osszTermes;
    }

    public double getAtlag() {
        return atlag;
    }

    @Override
    public String toString() {
        return String.format(
                "EvesTermes [ev=%s, osszTermes=%s, atlag=%s]", ev, osszTermes, atlag);
    }

}
