
package rpg.factory;

import rpg.character.Archer;
import rpg.character.Character;

public class ArcherFactory extends CharacterFactory {

    @Override
    public Character createCharacter(String name) {
        return new Archer(name);
    }
}

