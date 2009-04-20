grammar Cozily;
options {
    output=AST;
    ASTLabelType=CommonTree;
}
// $<CLASS LEVEL
program	:
	MODIFIER 'class' ID '{' '}'
	->
	^('class' MODIFIER ^('{' ID '}'))
	;

method	:	
	MODIFIER ID '{' '}'
	;
// $>
// $<STATEMENTS LEVEL

// $>
// $<TOKENS
MODIFIER:	'public'|'private'|'protected';	
NEW	:	'new';
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' +{skip();};
WS  :   (' '|'\t')+ {skip();} ;
// $>
