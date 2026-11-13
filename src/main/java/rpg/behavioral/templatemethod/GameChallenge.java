
package rpg.behavioral.templatemethod;

import java.util.ArrayList;
import java.util.List;

public abstract class GameChallenge {

    private final List<String> log = new ArrayList<>();

    public final void completeChallenge() {
        log.clear();

        prepare();
        meetEnemy();
        fight();
        receiveReward();
    }

    protected void prepare() {
        log.add("Готовы войти в подземелье?");
    }

    protected abstract void meetEnemy();

    protected abstract void fight();

    protected abstract void receiveReward();

    protected void addLog(String message) {
        log.add(message);
    }

    public List<String> getLog() {
        return new ArrayList<>(log);
    }
}
