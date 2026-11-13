
package rpg.generative.factory;

import rpg.generative.character.Character;

public abstract class CharacterFactory {

    public abstract Character createCharacter(String name);
}

