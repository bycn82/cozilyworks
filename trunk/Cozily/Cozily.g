grammar Cozily;
options {
    output=AST;
    ASTLabelType=CommonTree;
}
// $<CLASS LEVEL
methodstatement
	:	
	MODIFIER ID '{'	newstatement '}'->^(ID MODIFIER ^( newstatement '{' '}'))
	;
// $>
// $<STATEMENTS LEVEL
newstatement
	:
	ID ID '=' NEW ID'();'-> ^('=' ^(ID ID) ^(NEW ID '();'))	
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
