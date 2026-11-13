
package rpg.generative;

import org.junit.jupiter.api.Test;
import rpg.generative.character.Archer;
import rpg.generative.character.Character;
import rpg.generative.character.Mage;
import rpg.generative.character.Warrior;
import rpg.generative.factory.ArcherFactory;
import rpg.generative.factory.CharacterFactory;
import rpg.generative.factory.MageFactory;
import rpg.generative.factory.WarriorFactory;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFactoryTest {

    @Test
    void shouldCreateWarrior() {
        CharacterFactory factory = new WarriorFactory();

        Character character = factory.createCharacter("Steve");

        assertInstanceOf(Warrior.class, character);
        assertEquals("Steve", character.getName());
        assertEquals(20, character.getHealth());
    }

    @Test
    void shouldCreateMage() {
        CharacterFactory factory = new MageFactory();

        Character character = factory.createCharacter("Alex");

        assertInstanceOf(Mage.class, character);
        assertEquals(40, character.getHealth());
        assertTrue(character.getAbilities().contains("Фаербол"));
    }

    @Test
    void shouldCreateArcher() {
        CharacterFactory factory = new ArcherFactory();

        Character character = factory.createCharacter("Teomy");

        assertInstanceOf(Archer.class, character);
        assertEquals(20, character.getHealth());
        assertEquals(2, character.getStrength());
    }

    @Test
    void shouldCreateDifferentCharacters() {
        CharacterFactory warriorFactory = new WarriorFactory();
        CharacterFactory mageFactory = new MageFactory();

        Character warrior = warriorFactory.createCharacter("Steve");
        Character mage = mageFactory.createCharacter("Alex");

        assertNotSame(warrior, mage);
        assertNotEquals(warrior.getClass(), mage.getClass());
    }
}

