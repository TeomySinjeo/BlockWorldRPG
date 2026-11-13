
package rpg.behavioral.memento;

public class CharacterMemento {

    private final String name;
    private final int health;
    private final int strength;
    private final int armor;

    public CharacterMemento(
            String name,
            int health,
            int strength,
            int armor
    ) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getArmor() {
        return armor;
    }
}
