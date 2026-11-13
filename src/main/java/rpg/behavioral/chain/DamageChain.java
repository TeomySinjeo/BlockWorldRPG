
package rpg.behavioral.chain;

public class DamageChain {

    private final DamageHandler firstHandler;

    public DamageChain(int armorDefense, int shieldPercent) {
        ArmorHandler armor = new ArmorHandler(armorDefense);
        ShieldHandler shield = new ShieldHandler(shieldPercent);

        armor.setNext(shield);

        this.firstHandler = armor;
    }

    public int calculateDamage(int incomingDamage) {
        return firstHandler.handle(incomingDamage);
    }
}
