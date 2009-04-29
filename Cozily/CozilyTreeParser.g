tree grammar CozilyTreeParser;

options {
    backtrack = true; 
    memoize = true;
    tokenVocab = Cozily;
    ASTLabelType = CommonTree;
}
@treeparser::header{
package com.cozilyworks.cozily.parser;

import com.cozilyworks.cozily.codedom.*;
}

literal returns[Literal ltl]
    :   INTLITERAL{ltl=new Literal($INTLITERAL.text);}
    |   LONGLITERAL{ltl=new Literal($LONGLITERAL.text);}
    |   FLOATLITERAL{ltl=new Literal($FLOATLITERAL.text);}
    |   DOUBLELITERAL{ltl=new Literal($DOUBLELITERAL.text);}
    |   CHARLITERAL{ltl=new Literal($CHARLITERAL.text);}
    |   STRINGLITERAL{ltl=new Literal($STRINGLITERAL.text);}
    |   TRUE{ltl=new Literal($TRUE.text);}
    |   FALSE{ltl=new Literal($FALSE.text);}
    |   NULL{ltl=new Literal($NULL.text);}
    ;
primitiveType  returns[PrimitiveType type]
    :   'boolean'{type=new PrimitiveType("boolean");}
    |   'char'{type=new PrimitiveType("char");}
    |   'byte'{type=new PrimitiveType("byte");}
    |   'short'{type=new PrimitiveType("short");}
    |   'int'{type=new PrimitiveType("int");}
    |   'long'{type=new PrimitiveType("long");}
    |   'float'{type=new PrimitiveType("float");}
    |   'double'{type=new PrimitiveType("double");}
    ;
