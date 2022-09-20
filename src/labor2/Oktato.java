package labor2;

import java.util.Objects;

@SuppressWarnings("unused")
public class Oktato extends Szemely {
    private String tanszek;

    public Oktato(String nev, int eletkor, boolean ferfi, String tanszek) {
        super(nev, eletkor, ferfi);
        this.tanszek = tanszek;
    }

    public Oktato() {
        super();
        this.tanszek = "Informatikai Tanszék";
    }

    public String getTanszek() {
        return tanszek;
    }

    public void setTanszek(String tanszek) {
        this.tanszek = tanszek;
    }

    @Override
    public String toString() {
        return "Oktato{" +
                "nev='" + this.getNev() + '\'' +
                ", tanszek='" + tanszek + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Oktato oktato = (Oktato) o;
        return tanszek.equals(oktato.tanszek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tanszek);
    }
}
