
package rpg.generative;

import org.junit.jupiter.api.Test;
import rpg.generative.config.GameSettings;

import static org.junit.jupiter.api.Assertions.*;

class GameSettingsTest {

    @Test
    void shouldReturnSameInstance() {
        GameSettings first = GameSettings.getInstance();
        GameSettings second = GameSettings.getInstance();

        assertSame(first, second);
    }

    @Test
    void shouldChangeDifficulty() {
        GameSettings settings = GameSettings.getInstance();

        settings.setDifficulty("HARD");

        assertEquals("HARD", settings.getDifficulty());

        settings.setDifficulty("NORMAL");
    }

    @Test
    void shouldRejectInvalidDifficulty() {
        GameSettings settings = GameSettings.getInstance();

        assertThrows(
                IllegalArgumentException.class,
                () -> settings.setDifficulty("HARDCORE")
        );
    }

    @Test
    void shouldRejectNonPositiveDamageMultiplier() {
        GameSettings settings = GameSettings.getInstance();

        assertThrows(
                IllegalArgumentException.class,
                () -> settings.setDamageMultiplier(0)
        );
    }
}

