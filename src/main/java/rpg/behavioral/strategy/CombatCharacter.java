
package rpg.behavioral.strategy;

public class CombatCharacter {

    private final String name;
    private final int baseDamage;
    private int health;
    private CombatStrategy strategy;

    public CombatCharacter(
            String name,
            int health,
            int baseDamage,
            CombatStrategy strategy
    ) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("У персонажа должно быть имя!");
        }

        if (health <= 0 || baseDamage <= 0) {
            throw new IllegalArgumentException(
                    "Здоровье и урон не могут быть меньше нуля!"
            );
        }

        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Вы должны выбрать хотя бы 1-у стратегию (Обычная = Сбалансированая)"
            );
        }

        this.name = name;
        this.health = health;
        this.baseDamage = baseDamage;
        this.strategy = strategy;
    }

    public void setStrategy(CombatStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException(
                    "Вы должны выбрать хотя бы 1-у стратегию (Обычная = Сбалансированая)"
            );
        }

        this.strategy = strategy;
    }

    public void attack(CombatCharacter target) {
        if (target == null) {
            throw new IllegalArgumentException(
                    "Выберите хотя бы 1-у цель"
            );
        }

        if (target == this) {
            throw new IllegalArgumentException(
                    "Нельзя атаковать самого себя!"
            );
        }

        if (health <= 0) {
            throw new IllegalStateException(
                    "Мертвый персонаж не может атаковать!"
            );
        }

        int damage = strategy.calculateDamage(baseDamage);
        target.receiveDamage(damage);
    }

    public void receiveDamage(int incomingDamage) {
        if (incomingDamage < 0) {
            throw new IllegalArgumentException(
                    "Урон не может быть отрицательным!"
            );
        }

        int actualDamage =
                strategy.reduceIncomingDamage(incomingDamage);

        health = Math.max(0, health - actualDamage);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}

