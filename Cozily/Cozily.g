grammar Cozily;
options {
output=AST;
}

tokens {
  VAR;   // variable definition
  FUNC;  // function definition
  ARG;   // formal argument
  SLIST; // statement list
}
@header {
package com.cozilyworks.cozily.parser;
}
@lexer::header {
package com.cozilyworks.cozily.parser;
import com.cozilyworks.cozily.codedom.*;
import com.cozilyworks.cozily.codedom.impl.*;
}

add	:	
	ID '+' ID -> ^('+' ID ID)
	;



ID	:	('0'..'9')+;