package zhproba;

import java.util.Arrays;
import java.util.Optional;

public enum SzoloFajta {

    KEKFRANKOS(1),
    FURMINT(2),
    LEANYKA(3);

    public final int sorszam;

    private SzoloFajta(int sorszam) {
        this.sorszam = sorszam;
    }

    public static Optional<SzoloFajta> valueOf(int sorszam) {
        return Arrays.stream(SzoloFajta.values())
                .filter(t -> t.sorszam == sorszam)
                .findFirst();
    }

}
