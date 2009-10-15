tree grammar CozilyTreeParser;
options {
tokenVocab=Cozily; 
backtrack = true; 
memoize = true;
ASTLabelType = CommonTree;
}
@header {
package com.cozilyworks.cozily.parser;
import com.cozilyworks.cozily.codedom.*;
import com.cozilyworks.cozily.codedom.impl.*;
}



    