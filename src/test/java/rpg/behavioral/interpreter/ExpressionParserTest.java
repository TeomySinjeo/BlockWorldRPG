
package rpg.behavioral.interpreter;

import org.junit.jupiter.api.Test;
import rpg.generative.character.Warrior;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {

    private final ExpressionParser parser = new ExpressionParser();

    @Test
    void shouldInterpretHealthComparison() {
        Warrior warrior = new Warrior("Воин");

        Expression expression = parser.parse("HEALTH > 10");

        assertTrue(expression.interpret(warrior));
    }

    @Test
    void shouldInterpretStrengthComparison() {
        Warrior warrior = new Warrior("Воин");

        Expression expression = parser.parse("STRENGTH >= 4");

        assertTrue(expression.interpret(warrior));
    }

    @Test
    void shouldReturnFalseWhenConditionIsNotMet() {
        Warrior warrior = new Warrior("Воин");

        Expression expression = parser.parse("HEALTH < 10");

        assertFalse(expression.interpret(warrior));
    }

    @Test
    void shouldInterpretMultipleConditions() {
        Warrior warrior = new Warrior("Воин");

        Expression expression = parser.parse(
                "HEALTH > 10 AND STRENGTH >= 4 AND ARMOR == 20"
        );

        assertTrue(expression.interpret(warrior));
    }

    @Test
    void shouldReturnFalseWhenOneConditionIsNotMet() {
        Warrior warrior = new Warrior("Воин");

        Expression expression = parser.parse(
                "HEALTH > 10 AND STRENGTH > 10"
        );

        assertFalse(expression.interpret(warrior));
    }

    @Test
    void shouldRejectEmptyExpression() {
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("")
        );
    }

    @Test
    void shouldRejectUnknownAttribute() {
        assertThrows(
                IllegalArgumentException.class,
                () -> parser.parse("MANA > 10")
        );
    }
}

