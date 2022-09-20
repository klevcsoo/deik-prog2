package labor2;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Egyetem {
    private final List<Hallgato> hallgatoList;
    private final List<Oktato> oktatoList;

    /*
     * BÓNUSZ FELADAT:
     * members: lista: hallgatok es oktatok*/

    public Egyetem() {
        this.hallgatoList = new ArrayList<>();
        this.oktatoList = new ArrayList<>();
    }

    public List<Hallgato> getHallgatoList() {
        return hallgatoList;
    }

    public List<Oktato> getOktatoList() {
        return oktatoList;
    }

    public void addHallgato(Hallgato hallgato) {
        this.hallgatoList.add(hallgato);
    }

    public void addOktato(Oktato oktato) {
        this.oktatoList.add(oktato);
    }

    public List<Hallgato> getJoTanulok() {
        List<Hallgato> joTanulok = new ArrayList<>();
        for (var hallgato : this.hallgatoList) {
            if (hallgato.joTanulo()) joTanulok.add(hallgato);
        }
        return joTanulok;
    }

    @Override
    public String toString() {
        return "Egyetem{" +
                "hallgatoList=" + hallgatoList +
                ", oktatoList=" + oktatoList +
                '}';
    }
}
