package labor4.mikulas;

public class GyerekJatek extends Ajandek {
    int korhatar;

    public GyerekJatek(String nev, double tomeg, int ar, int korhatar) {
        super(nev, tomeg, ar);
        this.korhatar = korhatar;
    }

    public int getKorhatar() {
        return korhatar;
    }

    public void setKorhatar(int korhatar) {
        this.korhatar = korhatar;
    }

    @Override
    public String toString() {
        return this.korhatar == 0 ? super.toString() : "%s - %s éves kortól"
                .formatted(super.toString(), this.korhatar);
    }
}
