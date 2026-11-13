
package rpg.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {

    private final List<GameObserver> observers = new ArrayList<>();

    public void subscribe(GameObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException(
                    "Наблюдатель обязан существовать!"
            );
        }

        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void unsubscribe(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(GameEvent event) {
        if (event == null) {
            throw new IllegalArgumentException(
                    "Событие обязательно должно происходить!"
            );
        }

        for (GameObserver observer : observers) {
            observer.update(event);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}

