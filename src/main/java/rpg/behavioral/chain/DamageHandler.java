
package rpg.behavioral.chain;

public abstract class DamageHandler {

    protected DamageHandler nextHandler;

    public DamageHandler setNext(DamageHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public final int handle(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон должен снимать значения!");
        }

        int processedDamage = processDamage(damage);

        if (nextHandler != null) {
            return nextHandler.handle(processedDamage);
        }

        return processedDamage;
    }

    protected abstract int processDamage(int damage);
}
