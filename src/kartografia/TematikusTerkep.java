package kartografia;

import java.util.List;

class TematikusTerkep extends Terkep {
    private String tema;

    public TematikusTerkep(String cim, int arany, List<String> nevjegyzek, String tema)
            throws IllegalArgumentException {
        super(cim, arany, nevjegyzek);
        this.tema = tema;
    }

    @Override
    public boolean nagybetusit() {
        boolean out = super.nagybetusit();
        if (Character.isLowerCase(this.tema.charAt(0))) {
            out = true;
            this.tema = (
                    Character.toUpperCase(this.tema.charAt(0)) +
                            this.tema.substring(1)
            );
        }

        return out;
    }

    @Override
    public String toString() {
        return "%s, %s".formatted(((Terkep) this).toString(), this.tema);
    }
}
