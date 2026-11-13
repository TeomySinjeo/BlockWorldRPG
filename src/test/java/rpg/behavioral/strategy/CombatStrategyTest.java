
package rpg.behavioral.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombatStrategyTest {

    @Test
    void shouldDealDoubleDamageWithAggressiveStrategy() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 100, 20, new AggressiveStrategy()
        );

        CombatCharacter zombie = new CombatCharacter(
                "Зомби", 100, 10, new BalancedStrategy()
        );

        warrior.attack(zombie);

        assertEquals(60, zombie.getHealth());
    }

    @Test
    void shouldDealHalfDamageWithDefensiveStrategy() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 100, 20, new DefensiveStrategy()
        );

        CombatCharacter enemy = new CombatCharacter(
                "Зомби", 100, 10, new BalancedStrategy()
        );

        warrior.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }

    @Test
    void shouldDealNormalDamageWithBalancedStrategy() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 100, 20, new BalancedStrategy()
        );

        CombatCharacter enemy = new CombatCharacter(
                "Зомби", 100, 10, new BalancedStrategy()
        );

        warrior.attack(enemy);

        assertEquals(80, enemy.getHealth());
    }

    @Test
    void shouldReduceIncomingDamageWithDefensiveStrategy() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 100, 20, new DefensiveStrategy()
        );

        warrior.receiveDamage(40);

        assertEquals(80, warrior.getHealth());
    }

    @Test
    void shouldChangeStrategyDuringBattle() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 100, 20, new BalancedStrategy()
        );

        CombatCharacter enemy = new CombatCharacter(
                "Зомби", 100, 10, new BalancedStrategy()
        );

        warrior.setStrategy(new AggressiveStrategy());
        warrior.attack(enemy);

        assertEquals(60, enemy.getHealth());
    }

    @Test
    void shouldNotReduceHealthBelowZero() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 10, 20, new BalancedStrategy()
        );

        warrior.receiveDamage(100);

        assertEquals(0, warrior.getHealth());
    }

    @Test
    void shouldRejectNullStrategy() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CombatCharacter("Воин", 100, 20, null)
        );
    }

    @Test
    void shouldNotAllowDefeatedCharacterToAttack() {
        CombatCharacter warrior = new CombatCharacter(
                "Воин", 10, 20, new BalancedStrategy()
        );

        CombatCharacter enemy = new CombatCharacter(
                "Зомби", 100, 10, new BalancedStrategy()
        );

        warrior.receiveDamage(10);

        assertThrows(
                IllegalStateException.class,
                () -> warrior.attack(enemy)
        );
    }
}
