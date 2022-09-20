package labor2;

import java.util.Objects;

@SuppressWarnings("unused")
public class Szemely {
    private String nev;
    private int eletkor;
    private boolean ferfi;

    /*
     * FELADAT:
     * constructor: 3/0 params
     * getters, setters
     * toString, equals
     *
     * Hallgato subclass: double atlag
     * Oktato subclass: String tanszek
     * constructor: 3/0
     * getters, setters
     * toString, equals
     *
     * Hallgato: method: igaz, ha atlag >= 4 kulonben hamis*/

    public Szemely(String nev, int eletkor, boolean ferfi) {
        this.nev = nev;
        this.eletkor = eletkor;
        this.ferfi = ferfi;
    }

    public Szemely() {
        this("Anna Béla", 21, true);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    public boolean isFerfi() {
        return ferfi;
    }

    public void setFerfi(boolean ferfi) {
        this.ferfi = ferfi;
    }

    @Override
    public String toString() {
        return "Szemely{" +
                "nev='" + nev + '\'' +
                ", eletkor=" + eletkor +
                ", ferfi=" + ferfi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Szemely szemely = (Szemely) o;
        return eletkor == szemely.eletkor && ferfi == szemely.ferfi && nev.equals(szemely.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, eletkor, ferfi);
    }
}
