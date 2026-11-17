
package rpg.behavioral.mediator;

import rpg.generative.character.Mage;
import rpg.generative.character.Warrior;

public class BattleSetup {

    public static void main(String[] args) {
        GameBattleMediator mediator = new GameBattleMediator();

        BattleParticipant warrior =
                new BattleParticipant(new Warrior("Воин"), mediator, 100);

        BattleParticipant mage =
                new BattleParticipant(new Mage("Маг"), mediator, 80);

        mediator.addParticipant(warrior);
        mediator.addParticipant(mage);

        warrior.attack(mage);
        mage.sendMessage("Мне нужна помощь!");
    }
}

