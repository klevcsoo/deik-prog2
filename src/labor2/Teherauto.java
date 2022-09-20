package labor2;

@SuppressWarnings("unused")
public class Teherauto extends Auto {
    private int teherbiras;

    public Teherauto(String rendszam, int teljesitmeny, boolean automata, int teherbiras) {
        super(rendszam, teljesitmeny, automata);
        this.teherbiras = teherbiras;
    }

    public int getTeherbiras() {
        return teherbiras;
    }

    public void setTeherbiras(int teherbiras) {
        this.teherbiras = teherbiras;
    }

    @Override
    public String toString() {
        return "Teherauto{" +
                "teherbiras=" + teherbiras +
                '}';
    }
}
