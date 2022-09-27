package labor4.mikulas;

import java.util.Objects;

public class Ajandek {
    private String nev;
    private double tomeg;
    private int ar;

    /*
     * Getter/setter
     * toString
     * equals: ha a nevük megegysezik és max 1kg különbség van a súlyukban
     *
     * Gyerekjatek class: int korhatar
     * (toString-ban legyen benne)
     */

    public Ajandek(String nev, double tomeg, int ar) {
        this.nev = nev;
        this.tomeg = tomeg;
        this.ar = ar;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public double getTomeg() {
        return tomeg;
    }

    public void setTomeg(double tomeg) {
        this.tomeg = tomeg;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return "Ajándék: %s (%s kg, %s Ft)".formatted(
                this.nev, this.tomeg, this.ar
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || this.nev == null) {
            return false;
        }
        Ajandek ajandek = (Ajandek) o;
        boolean sameWeight = Math.abs(this.tomeg - ajandek.getTomeg()) < 1.0;
        return this.nev.equals(ajandek.getNev()) && sameWeight;
    }
}
