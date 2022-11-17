package repules;

public class Repulogep implements Comparable<Repulogep> {

    private String gyarto;
    private String tipus;
    private double hossz;
    private boolean isSugarhajtasu;

    public Repulogep(String gyarto, String tipus, double hossz, boolean isSugarhajtasu) {
        if (hossz <= 0) {
            throw new IllegalArgumentException("A hossz csak pozitív lehet!");
        }

        this.gyarto = gyarto;
        this.tipus = tipus;
        this.hossz = hossz;
        this.isSugarhajtasu = isSugarhajtasu;
    }

    public String getGyarto() {
        return gyarto;
    }

    public boolean isSugarhajtasu() {
        return isSugarhajtasu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Repulogep r = (Repulogep) obj;
        return this.tipus.equalsIgnoreCase(r.tipus) && this.gyarto.equalsIgnoreCase(r.gyarto);
    }

    @Override
    public String toString() {
        return "%s %s %srepülőgép, hossza: %s m".formatted(
                this.gyarto, this.tipus,
                this.isSugarhajtasu ? "" : "sugárhajtású ",
                this.hossz);
    }

    @Override
    public int compareTo(Repulogep o) {
        var gyarto = this.gyarto.compareToIgnoreCase(o.tipus);
        if (gyarto != 0)
            return gyarto;
        else
            return this.tipus.compareToIgnoreCase(o.tipus);
    }
}
