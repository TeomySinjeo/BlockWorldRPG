package rpg.behavioral.visitor;

public class MageUnit implements GameCharacter {

    private final int magicPower;
    private final int mana;

    public MageUnit(int magicPower, int mana) {
        if (magicPower < 0 || mana < 0) {
            throw new IllegalArgumentException(
                    "ЧИТЕР!!!!!"
            );
        }

        this.magicPower = magicPower;
        this.mana = mana;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public void accept(CharacterVisitor visitor) {
        visitor.visit(this);
    }
}
