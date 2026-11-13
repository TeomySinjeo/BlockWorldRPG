
package rpg.behavioral.strategy;

public class BalancedStrategy implements CombatStrategy {

    @Override
    public int calculateDamage(int baseDamage) {
        return baseDamage;
    }

    @Override
    public int reduceIncomingDamage(int incomingDamage) {
        return incomingDamage;
    }
}
