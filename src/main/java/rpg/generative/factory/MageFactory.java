
package rpg.generative.factory;

import rpg.generative.character.Character;
import rpg.generative.character.Mage;

public class MageFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Mage(name);
    }
}
