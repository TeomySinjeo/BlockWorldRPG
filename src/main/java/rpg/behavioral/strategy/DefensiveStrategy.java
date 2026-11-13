
package rpg.behavioral.strategy;

public class DefensiveStrategy implements CombatStrategy {

    @Override
    public int calculateDamage(int baseDamage) {
        return Math.max(1, baseDamage / 2);
    }

    @Override
    public int reduceIncomingDamage(int incomingDamage) {
        return incomingDamage / 2;
    }
}

