package labor7;

public class Player implements Comparable<Player> {
    private final String name;
    private final int age;
    private final int position;

    public Player(String name, int age, int position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        return this.age - o.age == 0 ? this.name.compareTo(o.name) : this.age - o.age;
    }
}
