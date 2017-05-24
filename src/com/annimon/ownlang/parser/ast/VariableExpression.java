package com.annimon.ownlang.parser.ast;

import com.annimon.ownlang.lib.Value;
import com.annimon.ownlang.lib.Variables;

public final class VariableExpression implements Expression {
    
    private final String name;
    
    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Variable does not exists");
        return Variables.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
