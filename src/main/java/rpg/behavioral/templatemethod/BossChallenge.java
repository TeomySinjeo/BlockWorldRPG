
package rpg.behavioral.templatemethod;

public class BossChallenge extends GameChallenge {

    @Override
    protected void meetEnemy() {
        addLog("Вы встретили Босса!");
    }

    @Override
    protected void fight() {
        addLog("Вы убили Босса");
    }

    @Override
    protected void receiveReward() {
        addLog("Вы получили Алмазный меч!");
    }
}

