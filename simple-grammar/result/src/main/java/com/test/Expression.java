package com.test;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class Expression {

    private final Operation operation;

    private final int left;

    private final int right;

    public Expression(Operation operation, int left, int right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public int execute() {
        return operation.apply(left, right);
    }

    public enum Operation {
        PLUS("+", (left, right) -> left + right),
        MINUS("-", (left, right) -> left - right),
        MULTIPLY("*", (left, right) -> left * right),
        DIVIDE("/", (left, right) -> left / right);

        private final String symbol;

        private final IntBinaryOperator action;

        Operation(String symbol, IntBinaryOperator action) {
            this.symbol = symbol;
            this.action = action;
        }

        public String getSymbol() {
            return symbol;
        }

        public int apply(int left, int right) {
            return action.applyAsInt(left, right);
        }

        public static Operation tryFindByName(String symbol) {
            return Stream.of(values())
                    .filter(operand -> operand.getSymbol().equals(symbol))
                    .findAny()
                    .orElse(null);
        }
    }
}
