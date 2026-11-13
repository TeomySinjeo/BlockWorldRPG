
package rpg.behavioral.chain;

public class ShieldHandler extends DamageHandler {

    private final int reductionPercent;

    public ShieldHandler(int reductionPercent) {
        if (reductionPercent < 0 || reductionPercent > 100) {
            throw new IllegalArgumentException(
                    "Защита должна быть от 0 до 100"
            );
        }

        this.reductionPercent = reductionPercent;
    }

    @Override
    protected int processDamage(int damage) {
        return damage * (100 - reductionPercent) / 100;
    }
}

