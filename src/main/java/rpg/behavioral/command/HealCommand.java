
package rpg.behavioral.command;

import rpg.generative.character.Character;

public class HealCommand implements GameCommand {

    private final Character character;
    private final int healAmount;
    private final int maxHealth;

    public HealCommand(
            Character character,
            int healAmount,
            int maxHealth
    ) {
        if (character == null) {
            throw new IllegalArgumentException("Персонаж должен существовать!");
        }

        if (healAmount <= 0 || maxHealth <= 0) {
            throw new IllegalArgumentException("Регенерация должна проходить!");
        }

        this.character = character;
        this.healAmount = healAmount;
        this.maxHealth = maxHealth;
    }

    @Override
    public void execute() {
        int newHealth = Math.min(
                maxHealth,
                character.getHealth() + healAmount
        );

        character.setHealth(newHealth);

        System.out.println(
                character.getName() + " выполнил регенерацию! Здоровье: "
                        + character.getHealth()
        );
    }
}
