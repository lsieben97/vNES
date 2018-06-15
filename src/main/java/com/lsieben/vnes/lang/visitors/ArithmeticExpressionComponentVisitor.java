package com.lsieben.vnes.lang.visitors;

import com.lsieben.vnes.lang.constructs.ArithmeticExpressionComponent;
import com.lsieben.vnes.lang.constructs.ArithmeticOperatorType;
import com.lsieben.vnes.parser.generated.vNESBaseVisitor;
import com.lsieben.vnes.parser.generated.vNESParser;

public class ArithmeticExpressionComponentVisitor extends vNESBaseVisitor<ArithmeticExpressionComponent> {

    @Override
    public ArithmeticExpressionComponent visitArithmeticExpressionComponent(vNESParser.ArithmeticExpressionComponentContext ctx) {
        ArithmeticExpressionComponent component = new ArithmeticExpressionComponent(ctx);

        component.setAtom(ctx.atom().accept(new ExpressionAtomVisitor()));

        if (ctx.arithmeticOperator().Addition() != null) {
            component.setOperatorType(ArithmeticOperatorType.Addition);
        } else if (ctx.arithmeticOperator().Devision() != null) {
            component.setOperatorType(ArithmeticOperatorType.Division);
        } else if (ctx.arithmeticOperator().Minus() != null) {
            component.setOperatorType(ArithmeticOperatorType.Minus);
        } else if (ctx.arithmeticOperator().Times() != null) {
            component.setOperatorType(ArithmeticOperatorType.Times);
        } else {
            // Todo: throw error.
        }

        return component;
    }
}