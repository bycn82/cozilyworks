grammar Cozily;
options {
	output=AST;
	backtrack=true;
	memoize=true;
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

// START:decl
program
    :   declaration+
    ;

declaration
    :   variable
    |   function
    ;

variable
    :   type ID ';' -> ^(VAR type ID)
    ;

type:   'int' 
    |   'char'
    ;
// END:decl

// START:func
// E.g., int f(int x, char y) { ... }
function
    :   type ID
        '(' ( formalParameter (',' formalParameter)* )?  ')'
        block
        -> ^(FUNC type ID formalParameter* block)
    ;

formalParameter
    :   type ID -> ^(ARG type ID)
    ;

// END:func

// START:stat
block
    :   lc='{' variable* stat* '}'
        -> ^(SLIST[$lc,"SLIST"] variable* stat*)
    ;

stat: forStat
    | expr ';'!
    | block
    | assignStat ';'!
    | ';'!
    ;

forStat
    :   'for' '(' first=assignStat ';' expr ';' inc=assignStat ')' block
        -> ^('for' $first expr $inc block)
    ;

assignStat
    :   ID '=' expr -> ^('=' ID expr)
    ;
// END:stat

// START:expr
expr:   condExpr ;

condExpr
    :   aexpr ( ('=='^|'!='^) aexpr )?
    ;

aexpr
    :   mexpr ('+'^ mexpr)*
    ;

mexpr
    :   atom ('*'^ atom)*
    ;

atom:   ID
    |   INT
    |   '(' expr ')' -> expr
    ;
// END:expr

// START:tokens
ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;

INT :   ('0'..'9')+ ;

WS  :   ( ' ' | '\t' | '\r' | '\n' )+ { $channel = HIDDEN; } ;    
// END:tokens
