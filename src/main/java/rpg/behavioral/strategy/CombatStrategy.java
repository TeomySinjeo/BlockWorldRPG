
package rpg.behavioral.strategy;

public interface CombatStrategy {

    int calculateDamage(int baseDamage);

    int reduceIncomingDamage(int incomingDamage);
}
