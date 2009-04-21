tree grammar CozilyTreeParser;

options {
    tokenVocab=Cozily;
    ASTLabelType=CommonTree;
}

@header {
import com.cozilyworks.cozily.compiler.codedom.*;
}

@members {

}

expression returns[Expression exp]
	:
	//argumentExpression
	^(type=ID arg=ID)
	{
	exp=new ArgumentExpression($type.text,$arg.text);
	}	
	;
