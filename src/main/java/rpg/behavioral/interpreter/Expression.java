
package rpg.behavioral.interpreter;

import rpg.generative.character.Character;

public interface Expression {
    boolean interpret(Character character);
}
