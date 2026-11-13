
package rpg.behavioral.interpreter;

import rpg.generative.character.Character;

public class ExpressionParser {

    public Expression parse(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Что то должно сравниваться с чем то!");
        }

        String[] parts = input.toUpperCase().trim().split("\\s+AND\\s+");

        Expression result = parseComparison(parts[0]);

        for (int i = 1; i < parts.length; i++) {
            result = new AndExpression(result, parseComparison(parts[i]));
        }

        return result;
    }

    private Expression parseComparison(String input) {
        String[] parts = input.trim().split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException(
                    "Неверное сравнение: " + input
            );
        }

        String attribute = parts[0];
        String operator = parts[1];

        if (!attribute.equals("HEALTH")
                && !attribute.equals("STRENGTH")
                && !attribute.equals("ARMOR")) {
            throw new IllegalArgumentException(
                    "Следующие характеристики в разрабротке... " + attribute
            );
        }

        if (!operator.equals(">") && !operator.equals("<")
                && !operator.equals(">=") && !operator.equals("<=")
                && !operator.equals("==")) {
            throw new IllegalArgumentException(
                    "Неизвестное сравнение: " + operator
            );
        }

        try {
            int value = Integer.parseInt(parts[2]);
            return new ComparisonExpression(attribute, operator, value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Должно сравниваться с числом!", exception);
        }
    }
}
