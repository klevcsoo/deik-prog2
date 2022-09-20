package labor2;

public class Main {
    public static void main(String[] args) {
        Teherauto teherauto = new Teherauto("NVT-184", 72, true, 20);
        System.out.println(teherauto);

        Pig pig = new Pig();
        pig.animalSound();

        Szemely szemelyTamas = new Szemely("Tamás", 25, true);
        Hallgato hallgatoCintia = new Hallgato("Cintia", 19, false, 4.2);
        Oktato oktatoGabor = new Oktato("Gábor", 38, true, "Informatikai Tanszék");

        System.out.println();
        System.out.println(szemelyTamas);
        System.out.println(hallgatoCintia);
        System.out.println(oktatoGabor);

        Szemely szemelyTamas2 = new Szemely("Tamás", 25, true);
        Hallgato hallgatoCintia2 = new Hallgato("Cintia", 19, false, 4.2);
        Hallgato hallgatoViktoria = new Hallgato("Viktória", 18, false, 3.8);

        System.out.println();
        System.out.println(szemelyTamas.equals(szemelyTamas2));
        System.out.println(hallgatoCintia.equals(hallgatoCintia2));
        System.out.println(hallgatoCintia.equals(hallgatoViktoria));

        Egyetem egyetem = new Egyetem();
        egyetem.addHallgato(hallgatoCintia);
        egyetem.addHallgato(hallgatoViktoria);
        egyetem.addHallgato(new Hallgato("Dávid", 22, true, 4.0));
        egyetem.addHallgato(new Hallgato("Klaudia", 28, false, 4.7));
        egyetem.addHallgato(new Hallgato("Zsolt", 18, true, 3.9));
        egyetem.addOktato(oktatoGabor);

        System.out.println("\nJó tanulók:");
        for (var hallgato : egyetem.getJoTanulok()) {
            System.out.println(hallgato);
        }
    }
}
