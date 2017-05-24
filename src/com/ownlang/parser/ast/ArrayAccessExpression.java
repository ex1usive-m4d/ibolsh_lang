package com.ownlang.parser.ast;

import com.ownlang.lib.ArrayValue;
import com.ownlang.lib.Value;
import com.ownlang.lib.Variables;


public final class ArrayAccessExpression implements Expression {
    
    private final String variable;
    private final Expression index;

    public ArrayAccessExpression(String variable, Expression index) {
        this.variable = variable;
        this.index = index;
    }
    
    @Override
    public Value eval() {
        final Value var = Variables.get(variable);
        if (var instanceof ArrayValue) {
            final ArrayValue array = (ArrayValue) var;
            return array.get((int) index.eval().asNumber());
        } else {
            throw new RuntimeException("Array expected");
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", variable, index);
    }
}
