
package rpg.behavioral.mediator;

public class BattleSetup {

    public static void main(String[] args) {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant("Воин", mediator, 100);

        BattleParticipant mage =
                new BattleParticipant("Маг", mediator, 80);

        mediator.addParticipant(warrior);
        mediator.addParticipant(mage);

        warrior.attack(mage);
        mage.sendMessage("Мне нужна помощь!");
    }
}

