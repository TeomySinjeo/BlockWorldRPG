
package rpg.behavioral.memento;

public class CharacterOriginator {

    private String name;
    private int health;
    private int strength;
    private int armor;

    public CharacterOriginator(
            String name,
            int health,
            int strength,
            int armor
    ) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("У персонажа должно быть имя!");
        }

        if (health <= 0 || strength < 0 || armor < 0) {
            throw new IllegalArgumentException("Вы читер!!!!!");
        }

        this.name = name;
        this.health = health;
        this.strength = strength;
        this.armor = armor;
    }

    public CharacterMemento save() {
        return new CharacterMemento(name, health, strength, armor);
    }

    public void restore(CharacterMemento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("У вас должно быть мимниму 1-но сохранение");
        }

        this.name = memento.getName();
        this.health = memento.getHealth();
        this.strength = memento.getStrength();
        this.armor = memento.getArmor();
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон должен снижать характеристики");
        }

        health = Math.max(0, health - damage);
    }

    public void changeStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException("Сила должна быть больше 0");
        }

        this.strength = strength;
    }

    public void changeArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException("Броня должна защищать");
        }

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

