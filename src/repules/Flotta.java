package repules;

import java.util.List;

public interface Flotta {

    /**
     * Új repülőgépet vesz fel a flottába.
     */
    public void felvesz(Repulogep repulo);

    /**
     * Visszaadja azoknak az utasszállítóknak a rendezett listáját (a természetes
     * rendezettség sorrendjében), amelyek legalább a paraméterben megkapott számú
     * férőhellyel rendelkeznek.
     */
    public List<Utasszallito> megfeleloGepek(int utasszam);

    /**
     * Kiírja a megadott állományba a repülőgépek listáját (mindegyiket külön
     * sorba).
     */
    public void kiir(String fajlnev);
}
