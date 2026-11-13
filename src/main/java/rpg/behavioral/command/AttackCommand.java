
package rpg.behavioral.command;

import rpg.generative.character.Character;

public class AttackCommand implements GameCommand {

    private final Character attacker;
    private final Character target;

    public AttackCommand(Character attacker, Character target) {
        if (attacker == null || target == null) {
            throw new IllegalArgumentException(
                    "Персонаж должен существовать!"
            );
        }

        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        int damage = attacker.getStrength();

        if (attacker.getWeapon() != null) {
            damage += attacker.getWeapon().getDamage();
        }

        target.setHealth(Math.max(1, target.getHealth() - damage));

        System.out.println(
                attacker.getName() + " атакует " +
                        target.getName() + " нанес " + damage + " урона"
        );

        System.out.println(
                "Осталось здоровья: " + target.getHealth()
        );
    }
}

