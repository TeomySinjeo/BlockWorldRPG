
package rpg.prototype;

public class EnemyPrototype implements Cloneable {

    private String name;
    private int health;
    private int damage;
    private int armor;

    public EnemyPrototype(String name, int health, int damage, int armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public EnemyPrototype clone() {
        try {
            return (EnemyPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public void showInfo() {
        System.out.println("Моб: " + name);
        System.out.println("Здоровье: " + health);
        System.out.println("Урон: " + damage);
        System.out.println("Броня: " + armor);
    }
}
