
package rpg.behavioral.command;

import rpg.generative.character.Character;

public class DefendCommand implements GameCommand {

    private final Character character;
    private final int defenseBonus;

    public DefendCommand(Character character, int defenseBonus) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж должен существовать!");
        }

        if (defenseBonus <= 0) {
            throw new IllegalArgumentException(
                    "Защита должна давать бонус!"
            );
        }

        this.character = character;
        this.defenseBonus = defenseBonus;
    }

    @Override
    public void execute() {
        character.setArmor(
                character.getArmor() + defenseBonus
        );

        System.out.println(
                character.getName() + " защищен броней! Поглотил: "
                        + character.getArmor()
        );
    }
}

