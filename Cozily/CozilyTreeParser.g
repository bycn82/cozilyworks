tree grammar CozilyTreeParser;
options {
tokenVocab=Cozily; 
ASTLabelType=CommonTree;
TokenLabelType=MyToken;
}
@header {
package com.cozilyworks.cozily.parser;
import com.cozilyworks.cozily.codedom.*;
import com.cozilyworks.cozily.codedom.impl.*;
}

add	:	
	^('+' a=ID b=ID){System.out.println(Integer.valueOf($a.text)+Integer.valueOf($b.text));}
	;