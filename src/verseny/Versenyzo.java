package verseny;

public abstract class Versenyzo implements Comparable<Versenyzo> {
    private int azonosito;
    private String nev;
    private String terulet;

    public Versenyzo(int azonosito, String nev, String terulet) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.terulet = terulet;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getNev() {
        return nev;
    }

    public String getTerulet() {
        return terulet;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        Versenyzo versenyzo = (Versenyzo) obj;
        return this.azonosito == versenyzo.getAzonosito();
    }

    @Override
    public String toString() {
        return "%s (%s), azonosítója: %s".formatted(
                this.nev, this.terulet, this.azonosito
        );
    }

    @Override
    public int compareTo(Versenyzo o) {
        int terulet = this.terulet.compareTo(o.getTerulet());
        if (terulet != 0) return terulet;

        int nev = this.nev.compareTo(o.getNev());
        if (nev != 0) return nev;

        return this.azonosito - o.getAzonosito();
    }
}
