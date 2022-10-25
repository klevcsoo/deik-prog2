package kartografia;

import java.util.*;

public class Atlasz implements TerkepTar {
    private final List<Terkep> terkepTar;
    private final String cim;

    public Atlasz(List<Terkep> terkepek, String cim) {
        this.terkepTar = terkepek;
        this.cim = cim;
    }

    @Override
    public void hozzaad(Terkep[] terkepek) {
        terkepTar.addAll(Arrays.asList(terkepek));
    }

    @Override
    public List<Terkep> terkepek(boolean csakTematikus, int nevekSzama) {
        List<Terkep> out = new ArrayList<>();
        for (var t : this.terkepTar) {
            if (t.nevjegyzek.size() >= nevekSzama) {
                if (!csakTematikus) out.add(t);
                else if (t instanceof TematikusTerkep) {
                    out.add(t);
                }
            }
        }

        out.sort(Terkep::compareTo);
        return out;
    }

    @Override
    public Collection<String> teljesNevjegyzek(String cim) {
        Collection<String> out = new ArrayList<>();
        for (var t : this.terkepTar) {
            if (t.cim.equals(cim)) {
                out.addAll(t.nevjegyzek);
            }
        }

        List<String> outList = new ArrayList<>(out);
        outList.sort(String::compareTo);
        out = new ArrayList<>(outList);
        return out;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("%s\n\n".formatted(this.cim));
        for (var t : this.terkepTar) {
            out.append("%s\n".formatted(t));
        }
        return out.toString();
    }
}
