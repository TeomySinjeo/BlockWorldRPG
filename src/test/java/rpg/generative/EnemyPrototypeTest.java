
package rpg.generative;

import org.junit.jupiter.api.Test;
import rpg.generative.prototype.EnemyPrototype;

import static org.junit.jupiter.api.Assertions.*;

class EnemyPrototypeTest {

    @Test
    void shouldCloneEnemy() {
        EnemyPrototype original = new EnemyPrototype(
                "Шторм Пустоты", 400, 8, 8
        );

        EnemyPrototype clone = original.clone();

        assertNotSame(original, clone);
        assertEquals(original.getName(), clone.getName());
        assertEquals(original.getHealth(), clone.getHealth());
        assertEquals(original.getDamage(), clone.getDamage());
        assertEquals(original.getArmor(), clone.getArmor());
    }

    @Test
    void shouldAllowChangingCloneWithoutChangingOriginal() {
        EnemyPrototype original = new EnemyPrototype(
                "Скелет", 20, 2, 1
        );

        EnemyPrototype clone = original.clone();
        clone.setHealth(20);

        assertEquals(20, original.getHealth());
        assertEquals(20, clone.getHealth());
    }

    @Test
    void shouldCreateIndependentClones() {
        EnemyPrototype original = new EnemyPrototype(
                "Зомби", 20, 3, 2
        );

        EnemyPrototype firstClone = original.clone();
        EnemyPrototype secondClone = original.clone();

        assertNotSame(firstClone, secondClone);

        firstClone.setName("Большой зомби");

        assertEquals("Зомби", original.getName());
        assertEquals("Зомби", secondClone.getName());
        assertEquals("Большой зомби", firstClone.getName());
    }

    @Test
    void shouldPreserveAllStatsWhenCloning() {
        EnemyPrototype original = new EnemyPrototype(
                "Дракон края", 200, 10, 1
        );

        EnemyPrototype clone = original.clone();

        assertEquals(200, clone.getHealth());
        assertEquals(10, clone.getDamage());
        assertEquals(1, clone.getArmor());
    }
}
