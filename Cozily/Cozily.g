grammar Cozily;
options {
    output=AST;
    ASTLabelType=CommonTree;
}
// $<CLASS LEVEL
methodstatement
	:	
	MODIFIER ID ID '(){' newstatements '}'->^(ID MODIFIER ^(ID ^('(){' newstatements '}')))
	;
// $>
// $<STATEMENTS LEVEL
newstatements
	:	newstatement+
	;
newstatement
	:
	ID ID '=' NEW ID'();'-> ^('=' ^(ID ID) ^(NEW ID '();'))	
	;
// $>
// $<TOKENS
// $<FRAGMENT

// $>

MODIFIER:	'public'|'private'|'protected';	


NEW	:	'new';
ID  :   ('a'..'z'|'A'..'Z')+ ;
INT :   '0'..'9'+ ;
NEWLINE:'\r'? '\n' +{skip();};
WS  :   (' '|'\t')+ {skip();} ;
// $>
