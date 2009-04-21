tree grammar CozilyTreeParser;

options {
    tokenVocab=Cozily;
    ASTLabelType=CommonTree;
}

@header {
package com.cozilyworks.cozily.compiler;
import com.cozilyworks.cozily.compiler.codedom.*;
}
@members {

}
argumentexpression returns[ArgumentExpression argExp]
	:
	^(type=ID arg=ID)
	{
	argExp=new ArgumentExpression($type.text,$arg.text);
	}
	;
expression returns[Expression exp]
	:
	^(NEW type=ID ^('(' e=argumentexpression ')'))
	{
	exp=new NewExpression($type.text,$e.argExp);
	}
	;
