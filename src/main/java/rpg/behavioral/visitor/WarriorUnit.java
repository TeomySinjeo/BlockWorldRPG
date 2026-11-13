package rpg.behavioral.visitor;

public class WarriorUnit implements GameCharacter {

    private final int strength;
    private final int armor;

    public WarriorUnit(int strength, int armor) {
        if (strength < 0 || armor < 0) {
            throw new IllegalArgumentException(
                    "ЧИТЕР!!!!!"
            );
        }

        this.strength = strength;
        this.armor = armor;
    }

    public int getStrength() {
        return strength;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }
}