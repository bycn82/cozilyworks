tree grammar CozilyTree;

options {
    tokenVocab=Cozily;
    ASTLabelType=CommonTree;
}

@header {
import java.util.HashMap;
}

@members {

}
function returns[FunctionExpression exp]
	:
	^(c=CONTROL 'class' i=ID ^('{' e=expression '}'))
	{
		exp=new FunctionExpression();
		exp.ctrl=$c.text;
		exp.name=$i.text;
		exp.exps.add($e.nexp);	
	}
	;
expression returns[NewExpression nexp]
	:
	^(type=ID id=ID ^('=' NEW ID '();'))
	{
	nexp=new NewExpression();
	nexp.type=$type.text;
	nexp.id=$id.text;
	}
	;
