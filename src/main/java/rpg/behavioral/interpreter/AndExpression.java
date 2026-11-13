
package rpg.behavioral.interpreter;

import rpg.generative.character.Character;

public class AndExpression implements Expression {

    private final Expression left;
    private final Expression right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Character character) {
        return left.interpret(character) && right.interpret(character);
    }
}

