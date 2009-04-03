grammar Cozily;
options {
    output=AST;
    ASTLabelType=CommonTree;
}
function
	:
	CONTROL  'class'  ID '{'
		expression
	'}'
	->
	^(CONTROL 'class' ID ^('{' expression '}'))
	;
expression
	:	
	ID ID '=' NEW ID'();'->^(ID ID ^('=' NEW ID '();'))
	
	;
	
NEW	:	'new';
CONTROL	:	'public';
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' +{skip();};
WS  :   (' '|'\t')+ {skip();} ;
