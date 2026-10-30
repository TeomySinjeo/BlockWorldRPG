
package rpg.character;

import rpg.equipment.Armor;
import rpg.equipment.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private String name;
    private int health;
    private int strength;
    private int armor;
    private List<String> abilities;

    private Weapon weapon;
    private Armor equipmentArmor;

    protected Character(String name, int health, int strength, int armor,
                        List<String> abilities) {
        setName(name);
        setHealth(health);
        setStrength(strength);
        setArmor(armor);
        setAbilities(abilities);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Введите ваш никнейм"
            );
        }
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            throw new IllegalArgumentException(
                    "Невозмжно существовать со здоровьем меньше либо равному 0"
            );
        }
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(
                    "Данная сила должна наносить минимум 1 единицу урона"
            );
        }
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(
                    "Невозможно создать броню которая не дает защиту"
            );
        }
        this.armor = armor;
    }

    public List<String> getAbilities() {
        return new ArrayList<>(abilities);
    }

    public void setAbilities(List<String> abilities) {
        if (abilities == null) {
            throw new IllegalArgumentException(
                    "У персонажа обязательно должна быть хотя бы 1 способность"
            );
        }
        this.abilities = new ArrayList<>(abilities);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getEquipmentArmor() {
        return equipmentArmor;
    }

    public void setEquipmentArmor(Armor equipmentArmor) {
        this.equipmentArmor = equipmentArmor;
    }

    public abstract String getClassName();

    public void showInfo() {
        System.out.println("Ник: " + name);
        System.out.println("Класс: " + getClassName());
        System.out.println("Здоровье: " + health);
        System.out.println("Сила: " + strength);
        System.out.println("Броня: " + armor);
        System.out.println("Способности: " + abilities);

        if (weapon != null) {
            System.out.println("Оружие: " + weapon.getName());
            System.out.println("Урон оружия: " + weapon.getDamage());
        }

        if (equipmentArmor != null) {
            System.out.println("Снаряжение: " + equipmentArmor.getName());
            System.out.println(
                    "Защита снаряжения: " + equipmentArmor.getDefense()
            );
        }
    }
}