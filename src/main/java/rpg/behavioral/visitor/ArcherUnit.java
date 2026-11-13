package rpg.behavioral.visitor;

public class ArcherUnit implements GameCharacter {

    private final int agility;
    private final int strength;

    public ArcherUnit(int agility, int strength) {
        if (agility < 0 || strength < 0) {
            throw new IllegalArgumentException(
                    "ЧИТЕР!!!!!"
            );
        }

        this.agility = agility;
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }
}