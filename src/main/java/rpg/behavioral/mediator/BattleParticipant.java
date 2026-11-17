
package rpg.behavioral.mediator;

import rpg.generative.character.Character;

public class BattleParticipant {

    private final Character character;
    private final BattleMediator mediator;
    private int health;

    public BattleParticipant(Character character, BattleMediator mediator, int health) {
        if (character == null) {
            throw new IllegalArgumentException("Должен быть персонаж!");
        }

        if (mediator == null) {
            throw new IllegalArgumentException("Медиатор должен существовать!");
        }

        if (health <= 0) {
            throw new IllegalArgumentException("Здоровье не может быть меньше 0!");
        }

        this.character = character;
        this.mediator = mediator;
        this.health = health;
    }

    public String getCharacterName() {
        return character.getName();
    }

    public int getHealth() {
        return health;
    }

    public void attack(BattleParticipant target) {
        mediator.attack(this, target);
    }

    public void receiveDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон должен снимать единицы!");
        }

        health = Math.max(0, health - damage);
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(character.getName() + " получил сообщение: " + message);
    }
}
