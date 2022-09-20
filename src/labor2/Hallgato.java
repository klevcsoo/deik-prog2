package labor2;

import java.util.Objects;

@SuppressWarnings("unused")
public class Hallgato extends Szemely {
    private double atlag;

    public Hallgato(String nev, int eletkor, boolean ferfi, double atlag) {
        super(nev, eletkor, ferfi);
        this.atlag = atlag;
    }

    public Hallgato() {
        super();
        this.atlag = 2.5;
    }

    public double getAtlag() {
        return atlag;
    }

    public void setAtlag(double atlag) {
        this.atlag = atlag;
    }

    public boolean joTanulo() {
        return this.atlag >= 4.0;
    }

    @Override
    public String toString() {
        return "Hallgato{" +
                "nev='" + this.getNev() + '\'' +
                ", atlag=" + atlag +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hallgato hallgato = (Hallgato) o;
        return Double.compare(hallgato.atlag, atlag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), atlag);
    }
}
