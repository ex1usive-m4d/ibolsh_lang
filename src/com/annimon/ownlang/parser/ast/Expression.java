package com.annimon.ownlang.parser.ast;

import com.annimon.ownlang.lib.Value;


public interface Expression {
    
    Value eval();
}
