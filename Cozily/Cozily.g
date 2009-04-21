grammar Cozily;
options {
    output=AST;
    ASTLabelType=CommonTree;
}
@header {
package com.cozilyworks.cozily.compiler;
}
@lexer::header {
package com.cozilyworks.cozily.compiler;
}
// $<CLASS LEVEL

// $>
// $<STATEMENTS LEVEL

// $>
// $<FRAGMENT
argumentexpression
	:	ID ID ->^(ID ID)
	;
expression
	:
	//newExpression
	NEW ID '(' argumentexpression ')'->^(NEW ID ^('(' argumentexpression ')'))	
	;
// $>
// $<TOKENS
MODIFIER:	'public'|'private'|'protected';	


NEW	:	'new';
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' +{skip();};
WS  :   (' '|'\t')+ {skip();} ;
// $>
