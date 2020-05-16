package com.test;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class Expression {

    private final Operand operand;

    private final int left;

    private final int right;

    public Expression(Operand operand, int left, int right) {
        this.operand = operand;
        this.left = left;
        this.right = right;
    }

    public int execute() {
        return operand.apply(left, right);
    }

    public enum Operand {
        PLUS("+", (left, right) -> left + right),
        MINUS("-", (left, right) -> left - right),
        MULTIPLY("*", (left, right) -> left * right),
        DIVIDE("/", (left, right) -> left / right);

        private final String symbol;

        private final IntBinaryOperator action;

        Operand(String symbol, IntBinaryOperator action) {
            this.symbol = symbol;
            this.action = action;
        }

        public String getSymbol() {
            return symbol;
        }

        public int apply(int left, int right) {
            return action.applyAsInt(left, right);
        }

        public static Operand tryFindBySymbol(String symbol) {
            return Stream.of(values())
                    .filter(operand -> operand.getSymbol().equals(symbol))
                    .findAny()
                    .orElse(null);
        }
    }
}
