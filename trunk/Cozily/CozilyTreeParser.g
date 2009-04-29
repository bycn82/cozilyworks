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

// $<SimpleElement
shiftOp returns[SimpleElement se]
    :    GT GT{se=new SimpleElement($GT.text+$GT.text);}
    |    LT LT{se=new SimpleElement($LT.text+$LT.text);}
    ;
literal returns[SimpleElement se]
    :   INTLITERAL{se=new Literal($INTLITERAL.text);}
    |   LONGLITERAL{se=new Literal($LONGLITERAL.text);}
    |   FLOATLITERAL{se=new Literal($FLOATLITERAL.text);}
    |   DOUBLELITERAL{se=new Literal($DOUBLELITERAL.text);}
    |   CHARLITERAL{se=new Literal($CHARLITERAL.text);}
    |   STRINGLITERAL{se=new Literal($STRINGLITERAL.text);}
    |   TRUE{se=new Literal($TRUE.text);}
    |   FALSE{se=new Literal($FALSE.text);}
    |   NULL{se=new Literal($NULL.text);}
    ;
primitiveType  returns[SimpleElement se]
    :   'boolean'{se=new PrimitiveType("boolean");}
    |   'char'{se=new PrimitiveType("char");}
    |   'byte'{se=new PrimitiveType("byte");}
    |   'short'{se=new PrimitiveType("short");}
    |   'int'{se=new PrimitiveType("int");}
    |   'long'{se=new PrimitiveType("long");}
    |   'float'{se=new PrimitiveType("float");}
    |   'double'{se=new PrimitiveType("double");}
    ;
// $>
