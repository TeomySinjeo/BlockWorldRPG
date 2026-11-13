
package rpg.behavioral.mediator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleMediatorTest {

    @Test
    void shouldRegisterParticipants() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        assertDoesNotThrow(() -> mediator.addParticipant(warrior));
    }

    @Test
    void shouldAttackThroughMediator() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        BattleParticipant mage =
                new BattleParticipant("Маг", mediator, 80);

        mediator.addParticipant(warrior);
        mediator.addParticipant(mage);

        warrior.attack(mage);

        assertEquals(75, mage.getHealth());
    }

    @Test
    void shouldNotAllowAttackOutsideBattle() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        BattleParticipant mage =
                new BattleParticipant("Маг", mediator, 80);

        mediator.addParticipant(warrior);

        assertThrows(
                IllegalArgumentException.class,
                () -> warrior.attack(mage)
        );
    }

    @Test
    void shouldNotAllowSelfAttack() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        mediator.addParticipant(warrior);

        assertThrows(
                IllegalArgumentException.class,
                () -> warrior.attack(warrior)
        );
    }

    @Test
    void shouldNotAttackDefeatedParticipant() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        BattleParticipant mage =
                new BattleParticipant("Маг", mediator, 5);

        mediator.addParticipant(warrior);
        mediator.addParticipant(mage);

        warrior.attack(mage);

        assertEquals(0, mage.getHealth());

        assertThrows(
                IllegalStateException.class,
                () -> warrior.attack(mage)
        );
    }

    @Test
    void shouldSendMessageToOtherParticipants() {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        BattleParticipant mage =
                new BattleParticipant("Маг", mediator, 80);

        mediator.addParticipant(warrior);
        mediator.addParticipant(mage);

        assertDoesNotThrow(
                () -> warrior.sendMessage("Нужна помощь!")
        );
    }

    @Test
    void shouldRejectNullParticipant() {
        GameBattleMediator mediator = new GameBattleMediator();

        assertThrows(
                IllegalArgumentException.class,
                () -> mediator.addParticipant(null)
        );
    }

    @Test
    void shouldRejectInvalidHealth() {
        GameBattleMediator mediator = new GameBattleMediator();

        assertThrows(
                IllegalArgumentException.class,
                () -> new BattleParticipant("Воин", mediator, 0)
        );
    }
}

