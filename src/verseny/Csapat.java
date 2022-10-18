package verseny;

import java.util.List;

public class Csapat extends Versenyzo {
    protected List<String> csapattagok;

    public Csapat(int azonosito, String nev, String terulet, List<String> csapattagok) {
        super(azonosito, nev, terulet);
        this.csapattagok = csapattagok;
    }

    public List<String> getCsapattagok() {
        return csapattagok;
    }

    @Override
    public String toString() {
        return "csapat: %s, tagjai: %s".formatted(
                super.toString(), String.join(", ", this.csapattagok)
        );
    }
}
