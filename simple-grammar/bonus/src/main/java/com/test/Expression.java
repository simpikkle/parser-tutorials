package com.test;

import java.util.function.DoubleBinaryOperator;
import java.util.stream.Stream;

public class Expression {

    private final Operand operand;

    private final double left;

    private final double right;

    public Expression(Operand operand, double left, double right) {
        this.operand = operand;
        this.left = left;
        this.right = right;
    }

    public double execute() {
        return operand.apply(left, right);
    }

    public enum Operand {
        PLUS("+", (left, right) -> left + right),
        MINUS("-", (left, right) -> left - right),
        MULTIPLY("*", (left, right) -> left * right),
        DIVIDE("/", (left, right) -> {
            if (right == 0) {
                throw new IllegalArgumentException("Cannot divide by zero.");
            }
            return left / right;
        });

        private final String symbol;

        private final DoubleBinaryOperator action;

        Operand(String symbol, DoubleBinaryOperator action) {
            this.symbol = symbol;
            this.action = action;
        }

        public String getSymbol() {
            return symbol;
        }

        public double apply(double left, double right) {
            return action.applyAsDouble(left, right);
        }

        public static Operand tryFindBySymbol(String symbol) {
            return Stream.of(values())
                    .filter(operand -> operand.getSymbol().equals(symbol))
                    .findAny()
                    .orElse(null);
        }
    }
}
