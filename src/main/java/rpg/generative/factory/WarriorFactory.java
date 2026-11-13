
package rpg.generative.factory;

import rpg.generative.character.Character;
import rpg.generative.character.Warrior;

public class WarriorFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Warrior(name);
    }
}
