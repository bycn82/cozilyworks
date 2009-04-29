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
import com.cozilyworks.cozily.codedom.impl.*;
}
// $<element
typeArgument 
    :   type
    |   '?'(('extends'
            |'super'
            )
            type
        )?
    ; 
type 
    :   classOrInterfaceType
        ('[' ']'
        )*
    |   primitiveType
        ('[' ']'
        )*
    ;
classOrInterfaceType 
    :   IDENTIFIER
        (typeArguments
        )?
        ('.' IDENTIFIER
            (typeArguments
            )?
        )*
    ;
typeArguments returns[TypeAguments tas]
	@init{tas=new TypeArguments();}
    :  ^(LT a=typeArgument{tas.add(a);} (^(COMMA b=typeArgument){tas.add(b);})* GT)
    ;
// $>
// $<SimpleElement
shiftOp returns[SimpleElement se]
    :  ^(SHIFTOP a=GT b=GT){se=ShiftOp($a.text+$b.text);}
    |  ^(SHIFTOP a=LT b=LT){se=ShiftOp($a.text+$b.text);}
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
    |   IDENTIFIER{se=new Literal($IDENTIFIER.text);}
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
