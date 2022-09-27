package labor4.mikulas;

import java.util.ArrayList;
import java.util.List;

public class Puttony implements AjandekCsomag {
    public List<Ajandek> ajandekok = new ArrayList<>();

    @Override
    public int osszErtek() {
        return ajandekok.stream()
                .map(Ajandek::getAr)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public int nehezebb(double t) {
        return 0;
    }
}
