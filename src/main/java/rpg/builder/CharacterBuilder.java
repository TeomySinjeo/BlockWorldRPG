
package rpg.builder;

import rpg.character.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterBuilder {

    private String name;
    private int health = 20;
    private int strength = 2;
    private int armor = 1;
    private List<String> abilities = new ArrayList<>();

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public CharacterBuilder setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public CharacterBuilder setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public CharacterBuilder addAbility(String ability) {
        abilities.add(ability);
        return this;
    }

    public Character build() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Придумайте ваш никнейм");
        }

        return new CustomCharacter(
                name,
                health,
                strength,
                armor,
                abilities
        );
    }

    private static class CustomCharacter extends Character {

        public CustomCharacter(
                String name,
                int health,
                int strength,
                int armor,
                List<String> abilities
        ) {
            super(name, health, strength, armor, abilities);
        }

        @Override
        public String getClassName() {
            return "Персонаж";
        }
    }
}

