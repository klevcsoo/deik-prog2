package kartografia;

import java.util.List;

public class Terkep implements Comparable<Terkep> {
    protected final String cim;
    protected final int arany;
    protected final List<String> nevjegyzek;

    public Terkep(String cim, int arany, List<String> nevjegyzek)
            throws IllegalArgumentException {
        if (arany <= 0) {
            throw new IllegalArgumentException("Hibás méretarány");
        }

        this.cim = cim;
        this.arany = arany;
        this.nevjegyzek = nevjegyzek;
    }

    public boolean nagybetusit() {
        boolean out = false;
        for (int i = 0; i < this.nevjegyzek.size(); i++) {
            if (Character.isLowerCase(this.nevjegyzek.get(i).charAt(0))) {
                out = true;
                String newWord = (
                        Character.toUpperCase(this.nevjegyzek.get(i).charAt(0)) +
                                this.nevjegyzek.get(i).substring(1)
                );
                this.nevjegyzek.set(i, newWord);
            }
        }

        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terkep terkep = (Terkep) o;
        return this.cim.equals(terkep.cim) && this.arany == terkep.arany;
    }

    @Override
    public String toString() {
        return "%s, 1:%s (%s)".formatted(
                this.cim,
                this.arany,
                String.join(", ", this.nevjegyzek)
        );
    }


    @Override
    public int compareTo(Terkep o) {
        int lex = this.cim.compareTo(o.cim);
        if (lex != 0) return lex;

        int meret = this.arany - o.arany;
        if (meret != 0) return meret;

        return o.nevjegyzek.size() - this.nevjegyzek.size();
    }
}
