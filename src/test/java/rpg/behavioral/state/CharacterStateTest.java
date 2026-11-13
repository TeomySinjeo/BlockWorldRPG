
package rpg.behavioral.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterStateTest {

    @Test
    void shouldStartInNormalState() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        assertInstanceOf(NormalState.class, character.getState());
    }

    @Test
    void shouldAttackInNormalState() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.attack();

        assertEquals(1, character.getAttackCount());
    }

    @Test
    void shouldNotAttackWhenStunned() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.stun();
        character.attack();

        assertEquals(0, character.getAttackCount());
        assertInstanceOf(StunnedState.class, character.getState());
    }

    @Test
    void shouldRecoverFromStun() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.stun();
        character.recover();
        character.attack();

        assertInstanceOf(NormalState.class, character.getState());
        assertEquals(1, character.getAttackCount());
    }

    @Test
    void shouldTakeDamageInNormalState() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.takeDamage(30);

        assertEquals(70, character.getHealth());
    }

    @Test
    void shouldBecomeDeadWhenHealthReachesZero() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.takeDamage(100);

        assertEquals(0, character.getHealth());
        assertInstanceOf(DeadState.class, character.getState());
    }

    @Test
    void shouldNotAttackWhenDead() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.takeDamage(100);
        character.attack();

        assertEquals(0, character.getAttackCount());
    }

    @Test
    void shouldNotTakeDamageWhenDead() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        character.takeDamage(100);
        character.takeDamage(50);

        assertEquals(0, character.getHealth());
    }

    @Test
    void shouldRejectNegativeDamage() {
        CharacterStateContext character =
                new CharacterStateContext(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> character.takeDamage(-10)
        );
    }

    @Test
    void shouldRejectInvalidInitialHealth() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CharacterStateContext(0)
        );
    }
}
