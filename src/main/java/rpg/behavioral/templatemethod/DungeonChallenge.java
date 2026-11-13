
package rpg.behavioral.templatemethod;

public class DungeonChallenge extends GameChallenge {

    @Override
    protected void meetEnemy() {
        addLog("Вы встретили мобов!");
    }

    @Override
    protected void fight() {
        addLog("Вы убили всех мобов");
    }

    @Override
    protected void receiveReward() {
        addLog("Вы получили 100 злота");
    }
}
