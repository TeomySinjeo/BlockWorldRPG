
package rpg.behavioral.mediator;

public class BattleParticipant {

    private final String name;
    private final BattleMediator mediator;
    private int health;

    public BattleParticipant(String name, BattleMediator mediator, int health) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("У каждого персонаж есть свое имя!");
        }

        if (mediator == null) {
            throw new IllegalArgumentException("Медиатор должен существовать!");
        }

        if (health <= 0) {
            throw new IllegalArgumentException("Здоровье не может быть меньше 0!");
        }

        this.name = name;
        this.mediator = mediator;
        this.health = health;
    }

    public String getName() {
        return name;
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
        System.out.println(name + " получил сообщение: " + message);
    }
}
