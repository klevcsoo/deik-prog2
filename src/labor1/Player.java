package labor1;

import java.util.Objects;

public class Player {
    private String name;
    private int health;
    private int armour;
    private int x, y;

    public Player(String name, int health, int armour, int x, int y) {
        this.name = name;
        this.health = health;
        this.armour = armour;
        this.x = x;
        this.y = y;
    }

    public Player() {
        this.name = "Tom";
        this.health = 100;
        this.armour = 40;
        this.x = 0;
        this.y = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "labor1.Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", armour=" + armour +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return (
                health == player.health && armour == player.armour &&
                        x == player.x && y == player.y && name.equals(player.name)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, armour, x, y);
    }

    public void moveUp(int amount) {
        this.y -= amount;
    }
}
