
package rpg.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory implements Iterable<GameItem> {

    private final List<GameItem> items = new ArrayList<>();

    public void addItem(GameItem item) {
        if (item == null) {
            throw new IllegalArgumentException(
                    "Предмет должет существовать если он есть в инвенторе!"
            );
        }

        items.add(item);
    }

    public int getSize() {
        return items.size();
    }

    @Override
    public Iterator<GameItem> iterator() {
        return new InventoryIterator(items);
    }
}

