grammar Cozily;
options {
	output=AST;
	backtrack=true;
	memoize=true;
}

tokens {
  VAR;   // variable definition
}

@header {
package com.cozilyworks.cozily.parser;
}
@lexer::header {
package com.cozilyworks.cozily.parser;
import com.cozilyworks.cozily.codedom.*;
import com.cozilyworks.cozily.codedom.impl.*;
}

