
package rpg.factory;

import rpg.character.Character;
import rpg.character.Mage;

public class MageFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Mage(name);
    }
}
