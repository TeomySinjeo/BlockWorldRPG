
package rpg.behavioral.observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEventManagerTest {

    @Test
    void shouldSubscribeObserver() {
        GameEventManager manager = new GameEventManager();
        BattleLogObserver observer = new BattleLogObserver();

        manager.subscribe(observer);

        assertEquals(1, manager.getObserverCount());
    }

    @Test
    void shouldNotSubscribeSameObserverTwice() {
        GameEventManager manager = new GameEventManager();
        BattleLogObserver observer = new BattleLogObserver();

        manager.subscribe(observer);
        manager.subscribe(observer);

        assertEquals(1, manager.getObserverCount());
    }

    @Test
    void shouldUnsubscribeObserver() {
        GameEventManager manager = new GameEventManager();
        BattleLogObserver observer = new BattleLogObserver();

        manager.subscribe(observer);
        manager.unsubscribe(observer);

        assertEquals(0, manager.getObserverCount());
    }

    @Test
    void shouldNotifyObserverAboutEvent() {
        GameEventManager manager = new GameEventManager();
        BattleLogObserver observer = new BattleLogObserver();

        manager.subscribe(observer);

        manager.notifyObservers(
                new GameEvent("VICTORY", "Воин убил дракона!")
        );

        assertEquals(
                "Воин убил дракона!",
                observer.getLogs().get(0)
        );
    }

    @Test
    void shouldNotifyMultipleObservers() {
        GameEventManager manager = new GameEventManager();

        BattleLogObserver first = new BattleLogObserver();
        BattleLogObserver second = new BattleLogObserver();

        manager.subscribe(first);
        manager.subscribe(second);

        manager.notifyObservers(
                new GameEvent("VICTORY", "Победа!")
        );

        assertEquals(1, first.getLogs().size());
        assertEquals(1, second.getLogs().size());
    }

    @Test
    void shouldNotNotifyUnsubscribedObserver() {
        GameEventManager manager = new GameEventManager();
        BattleLogObserver observer = new BattleLogObserver();

        manager.subscribe(observer);
        manager.unsubscribe(observer);

        manager.notifyObservers(
                new GameEvent("VICTORY", "Победа!")
        );

        assertTrue(observer.getLogs().isEmpty());
    }

    @Test
    void shouldRejectNullObserver() {
        GameEventManager manager = new GameEventManager();

        assertThrows(
                IllegalArgumentException.class,
                () -> manager.subscribe(null)
        );
    }

    @Test
    void shouldRejectNullEvent() {
        GameEventManager manager = new GameEventManager();

        assertThrows(
                IllegalArgumentException.class,
                () -> manager.notifyObservers(null)
        );
    }
}
