package com.test;

import com.test.antlr.MathGrammarBaseListener;
import com.test.antlr.MathGrammarParser;

public class MathListener extends MathGrammarBaseListener {

    private Expression expression;

    @Override
    public void enterExpression(MathGrammarParser.ExpressionContext ctx) {
        Expression.Operand operand = Expression.Operand
                .tryFindBySymbol(ctx.operand().getText());
        double left = Double.parseDouble(ctx.number().get(0).getText());
        double right = Double.parseDouble(ctx.number().get(1).getText());
        expression = new Expression(operand, left, right);
    }

    public Expression getExpression() {
        return expression;
    }
}
