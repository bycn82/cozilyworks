tree grammar CozilyTreeParser;

options {
    backtrack = true; 
    memoize = true;
    tokenVocab = Cozily;
    ASTLabelType = CommonTree;
}
@treeparser::header{
package com.cozilyworks.cozily.parser;
}

getINT	:	^(GET_INT INT ID)
{
System.out.println($GET_INT.text);
System.out.println($INT.text);
System.out.println($ID.text);
}
;
