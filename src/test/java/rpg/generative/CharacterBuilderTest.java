
package rpg.generative;

import org.junit.jupiter.api.Test;
import rpg.generative.builder.CharacterBuilder;
import rpg.generative.character.Character;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBuilderTest {

    @Test
    void shouldBuildCharacterWithCustomStats() {
        Character hero = new CharacterBuilder()
                .setName("Teomy")
                .setHealth(20)
                .setStrength(2)
                .setArmor(1)
                .build();

        assertEquals("Teomy", hero.getName());
        assertEquals(20, hero.getHealth());
        assertEquals(2, hero.getStrength());
        assertEquals(1, hero.getArmor());
    }

    @Test
    void shouldAddAbilities() {
        Character hero = new CharacterBuilder()
                .setName("VoidMage")
                .addAbility("Фаербол")
                .addAbility("Огненный магический щит")
                .build();

        assertEquals(2, hero.getAbilities().size());
        assertTrue(hero.getAbilities().contains("Огненный магический щит"));
    }

    @Test
    void shouldUseDefaultStats() {
        Character hero = new CharacterBuilder()
                .setName("DefaultHero")
                .build();

        assertEquals(20, hero.getHealth());
        assertEquals(2, hero.getStrength());
        assertEquals(1, hero.getArmor());
    }

    @Test
    void shouldRejectEmptyName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CharacterBuilder().setName("").build()
        );
    }
}
