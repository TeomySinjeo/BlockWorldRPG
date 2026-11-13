
package rpg.behavioral.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterMementoTest {

    @Test
    void shouldSaveCharacterState() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        CharacterMemento snapshot = warrior.save();

        assertEquals(100, snapshot.getHealth());
        assertEquals(20, snapshot.getStrength());
        assertEquals(15, snapshot.getArmor());
    }

    @Test
    void shouldRestoreCharacterState() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        CharacterMemento snapshot = warrior.save();

        warrior.takeDamage(50);
        warrior.changeStrength(5);
        warrior.changeArmor(2);

        warrior.restore(snapshot);

        assertEquals(100, warrior.getHealth());
        assertEquals(20, warrior.getStrength());
        assertEquals(15, warrior.getArmor());
    }

    @Test
    void shouldRestoreCharacterName() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        CharacterMemento snapshot = warrior.save();

        warrior.restore(snapshot);

        assertEquals("Воин", warrior.getName());
    }

    @Test
    void shouldStoreMultipleSnapshots() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        CharacterHistory history = new CharacterHistory();

        history.save(warrior.save());

        warrior.takeDamage(30);
        history.save(warrior.save());

        assertEquals(2, history.getSaveCount());
    }

    @Test
    void shouldRestorePreviousSnapshot() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        CharacterHistory history = new CharacterHistory();

        history.save(warrior.save());

        warrior.takeDamage(40);
        history.save(warrior.save());

        CharacterMemento previous = history.undo();
        warrior.restore(previous);

        assertEquals(60, warrior.getHealth());
        assertEquals(1, history.getSaveCount());
    }

    @Test
    void shouldThrowWhenHistoryIsEmpty() {
        CharacterHistory history = new CharacterHistory();

        assertThrows(
                IllegalStateException.class,
                history::undo
        );
    }

    @Test
    void shouldRejectNegativeDamage() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        assertThrows(
                IllegalArgumentException.class,
                () -> warrior.takeDamage(-10)
        );
    }

    @Test
    void shouldRejectNullMemento() {
        CharacterOriginator warrior =
                new CharacterOriginator("Воин", 100, 20, 15);

        assertThrows(
                IllegalArgumentException.class,
                () -> warrior.restore(null)
        );
    }
}
