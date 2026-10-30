
package rpg.factory;

import rpg.character.Character;
import rpg.character.Warrior;

public class WarriorFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Warrior(name);
    }
}
