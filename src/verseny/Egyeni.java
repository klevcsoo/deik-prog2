package verseny;

public class Egyeni extends Versenyzo {
    protected int eletkor;

    public Egyeni(int azonosito, String nev, String terulet, int eletkor) {
        super(azonosito, nev, terulet);
        this.eletkor = eletkor;
    }

    public int getEletkor() {
        return eletkor;
    }

    @Override
    public String toString() {
        return "egyéni versenyző: %s, kora: %s év".formatted(
                super.toString(), this.eletkor
        );
    }
}
