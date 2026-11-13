
package rpg.behavioral.interpreter;

import rpg.generative.character.Character;

public class ComparisonExpression implements Expression {

    private final String attribute;
    private final String operator;
    private final int value;

    public ComparisonExpression(String attribute, String operator, int value) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public boolean interpret(Character character) {
        int actualValue;

        switch (attribute) {
            case "HEALTH" -> actualValue = character.getHealth();
            case "STRENGTH" -> actualValue = character.getStrength();
            case "ARMOR" -> actualValue = character.getArmor();
            default -> throw new IllegalArgumentException(
                    "Следующие характеристики в разработке... " + attribute
            );
        }

        return switch (operator) {
            case ">" -> actualValue > value;
            case "<" -> actualValue < value;
            case ">=" -> actualValue >= value;
            case "<=" -> actualValue <= value;
            case "==" -> actualValue == value;
            default -> throw new IllegalArgumentException(
                    "Неизвестное сравнение: " + operator
            );
        };
    }
}
