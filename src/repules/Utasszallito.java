package repules;

public class Utasszallito extends Repulogep {

    private int ferohely;

    public Utasszallito(String gyarto, String tipus, double hossz,
            boolean isSugarhajtasu, int ferohely) {
        super(gyarto, tipus, hossz, isSugarhajtasu);
        this.ferohely = ferohely;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    @Override
    public String toString() {
        return String.format("%s, %s férőhelyes", super.toString(), this.ferohely);
    }
}
