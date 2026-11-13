
package rpg.behavioral.chain;

public class ArmorHandler extends DamageHandler {

    private final int defense;

    public ArmorHandler(int defense) {
        if (defense < 0) {
            throw new IllegalArgumentException(
                    "Броня должна защищать!"
            );
        }

        this.defense = defense;
    }

    @Override
    protected int processDamage(int damage) {
        return Math.max(0, damage - defense);
    }
}
