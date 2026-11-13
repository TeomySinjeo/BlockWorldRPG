
package rpg.generative.factory;

import rpg.generative.character.Archer;
import rpg.generative.character.Character;

public class ArcherFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Archer(name);
    }
}

