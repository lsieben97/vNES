package com.lsieben.vnes.lang.constructs.statements;

import com.lsieben.vnes.lang.constructs.Expression;
import org.antlr.v4.runtime.ParserRuleContext;

public class ReturnStatement extends Statement {
    private Expression expression;

    public ReturnStatement(ParserRuleContext context) {
        super(context);
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
