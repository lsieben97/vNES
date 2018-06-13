package com.lsieben.vnes.lang.constructs;

import org.antlr.v4.runtime.ParserRuleContext;

public class ArithmeticExpressionComponent extends LanguageConstruct {
    private ArithmeticOperatorType operatorType;
    private ExpressionAtom atom;

    public ArithmeticExpressionComponent(ParserRuleContext context) {
        super(context);
    }

    public ExpressionAtom getAtom() {
        return atom;
    }

    public void setAtom(ExpressionAtom atom) {
        this.atom = atom;
    }

    public ArithmeticOperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(ArithmeticOperatorType operatorType) {
        this.operatorType = operatorType;
    }
}
