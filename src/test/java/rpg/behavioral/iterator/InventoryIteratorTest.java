
package rpg.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryIteratorTest {

    @Test
    void shouldAddItemsToInventory() {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("Деревянный меч"));
        inventory.addItem(new GameItem("Щит"));

        assertEquals(2, inventory.getSize());
    }

    @Test
    void shouldIterateThroughAllItems() {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("Деревянный меч"));
        inventory.addItem(new GameItem("Щит"));
        inventory.addItem(new GameItem("Зелье ускорения"));

        Iterator<GameItem> iterator = inventory.iterator();

        assertEquals("Деревянный меч", iterator.next().getName());
        assertEquals("Щит", iterator.next().getName());
        assertEquals("Зелье ускорения", iterator.next().getName());

        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldReturnFalseForEmptyInventory() {
        Inventory inventory = new Inventory();

        assertFalse(inventory.iterator().hasNext());
    }

    @Test
    void shouldThrowExceptionWhenNoItemsLeft() {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("Деревянный меч"));

        Iterator<GameItem> iterator = inventory.iterator();

        iterator.next();

        assertThrows(
                NoSuchElementException.class,
                iterator::next
        );
    }

    @Test
    void shouldRejectNullItem() {
        Inventory inventory = new Inventory();

        assertThrows(
                IllegalArgumentException.class,
                () -> inventory.addItem(null)
        );
    }

    @Test
    void shouldCreateIndependentIterators() {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("Деревянный меч"));
        inventory.addItem(new GameItem("Щит"));

        Iterator<GameItem> first = inventory.iterator();
        Iterator<GameItem> second = inventory.iterator();

        first.next();

        assertEquals("Деревянный меч", second.next().getName());
    }

    @Test
    void shouldIterateUsingForEach() {
        Inventory inventory = new Inventory();

        inventory.addItem(new GameItem("Деревянный меч"));
        inventory.addItem(new GameItem("Щит"));

        int count = 0;

        for (GameItem item : inventory) {
            assertNotNull(item.getName());
            count++;
        }

        assertEquals(2, count);
    }
}
