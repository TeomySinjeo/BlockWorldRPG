
package rpg.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class BattleLogObserver implements GameObserver {

    private final List<String> logs = new ArrayList<>();

    @Override
    public void update(GameEvent event) {
        logs.add(event.getMessage());
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
}

