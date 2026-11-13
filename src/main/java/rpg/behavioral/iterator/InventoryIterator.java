
package rpg.behavioral.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class InventoryIterator implements Iterator<GameItem> {

    private final List<GameItem> items;
    private int position = 0;

    public InventoryIterator(List<GameItem> items) {
        if (items == null) {
            throw new IllegalArgumentException(
                    "Предметы должны быть в инвенторе, если они есть!"
            );
        }

        this.items = List.copyOf(items);
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public GameItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException(
                    "Инвентарь пуст"
            );
        }

        return items.get(position++);
    }
}
