
package rpg.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class CharacterHistory {

    private final List<CharacterMemento> history = new ArrayList<>();

    public void save(CharacterMemento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("У вас должно быть минимум 1-но сохранение!");
        }

        history.add(memento);
    }

    public CharacterMemento undo() {
        if (history.isEmpty()) {
            throw new IllegalStateException("У вас нет сохранений");
        }

        return history.remove(history.size() - 1);
    }

    public int getSaveCount() {
        return history.size();
    }
}
