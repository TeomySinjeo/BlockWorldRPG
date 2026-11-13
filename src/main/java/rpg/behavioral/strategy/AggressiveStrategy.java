
package rpg.behavioral.strategy;

public class AggressiveStrategy implements CombatStrategy {

    @Override
    public int calculateDamage(int baseDamage) {
        return baseDamage * 2;
    }

    @Override
    public int reduceIncomingDamage(int incomingDamage) {
        return incomingDamage;
    }
}
