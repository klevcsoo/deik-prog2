package kartografia;

public interface TerkepTar {
    void hozzaad(Terkep[] terkepek);

    java.util.List<Terkep> terkepek(boolean csakTematikus, int nevekSzama);

    java.util.Collection<String> teljesNevjegyzek(String cim);
}
