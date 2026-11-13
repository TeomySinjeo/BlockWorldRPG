
package rpg.behavioral.command;

import org.junit.jupiter.api.Test;
import rpg.generative.character.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void shouldExecuteAttackCommand() {
        Warrior attacker = new Warrior("Нападающий");
        Warrior target = new Warrior("Цель");

        AttackCommand command = new AttackCommand(attacker, target);
        command.execute();

        // Сила воина равна 4, поэтому здоровье цели уменьшится с 20 до 16
        assertEquals(16, target.getHealth());
    }

    @Test
    void shouldExecuteHealCommand() {
        Warrior warrior = new Warrior("Воин");

        warrior.setHealth(10);

        HealCommand command = new HealCommand(warrior, 5, 20);
        command.execute();

        assertEquals(15, warrior.getHealth());
    }

    @Test
    void shouldNotHealAboveMaximumHealth() {
        Warrior warrior = new Warrior("Воин");

        HealCommand command = new HealCommand(warrior, 10, 20);
        command.execute();

        assertEquals(20, warrior.getHealth());
    }

    @Test
    void shouldExecuteDefendCommand() {
        Warrior warrior = new Warrior("Воин");

        DefendCommand command = new DefendCommand(warrior, 5);
        command.execute();

        assertEquals(25, warrior.getArmor());
    }

    @Test
    void shouldExecuteCommandThroughInvoker() {
        Warrior warrior = new Warrior("Воин");
        CommandInvoker invoker = new CommandInvoker();

        invoker.executeCommand(new DefendCommand(warrior, 10));

        assertEquals(30, warrior.getArmor());
    }

    @Test
    void shouldRejectNullCommand() {
        CommandInvoker invoker = new CommandInvoker();

        assertThrows(
                IllegalArgumentException.class,
                () -> invoker.executeCommand(null)
        );
    }
}

