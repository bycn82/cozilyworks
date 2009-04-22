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
// $<BLOCK 
classblock
	:MODIFIER 'class' ID '{' methodblock* '}'
	;
methodblock
	:MODIFIER ID ID'(){' 	definestatement* '}'
	;
// $>
// $<STATEMENT
definestatement
	:	ID ID '=' newexpression ';'
	;
// $>
// $<EXPRESSION
newexpression
	:	NEW ID '(' parametersexpression ')';
argumentsexpression
	:	ID ID (',' ID ID)*
	;
parametersexpression 
	:
	ID (',' ID)* 
	;	
// $>
// $<BASIC ELEMENT
stringelement
	:	'"' ID '"'
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
