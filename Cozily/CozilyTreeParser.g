tree grammar CozilyTreeParser;

options {
    tokenVocab=Cozily;
    ASTLabelType=CommonTree;
}

@header {
package com.cozilyworks.cozily.compiler;

import com.cozilyworks.cozily.compiler.codedom.block.*;
import com.cozilyworks.cozily.compiler.codedom.element.*;
import com.cozilyworks.cozily.compiler.codedom.expression.*;
import com.cozilyworks.cozily.compiler.codedom.statement.*;
}
// $<BLOCK 
classblock returns[ClassBlock cb]
	@init{cb=new ClassBlock();}
	:a=MODIFIER 'class' b=ID '{' (c=methodblock{cb.mblocks.add(c);})* '}' {cb.modifier=$a.text;cb.name=$b.text;}
	;
methodblock returns[MethodBlock mb]
	@init{mb=new MethodBlock();}
	:a=MODIFIER b=ID c=ID'(){' 	(d=definestatement{mb.stmts.add(d);})* '}'{mb.modifier=$a.text;mb.rtype=$b.text;mb.name=$c.text;}
	;
// $>
// $<STATEMENT
definestatement returns[DefineStatement dstmt]
	@init{dstmt=new DefineStatement();}
	:	a=ID b=ID '=' c=newexpression ';'{dstmt.type=$a.text;dstmt.var=$b.text;dstmt.nexp=c;}
	;
// 4>
// $<EXPRESSION
newexpression returns[NewExpression nexp]
	@init{nexp=new NewExpression();}
	:	NEW a=ID '(' b=parametersexpression ')'{nexp.type=$a.text;nexp.pexp=b;}
	;
argumentsexpression returns[ArgumentsExpression aexp]
	@init{ aexp=new ArgumentsExpression();}
	:	a=ID b=ID{ aexp.params.add($a.text);aexp.vars.add($b.text);} (',' aa=ID bb=ID{ aexp.params.add($aa.text);aexp.vars.add($bb.text);})*
	;
parametersexpression returns[ParametersExpression pexp]
	@init{ pexp=new ParametersExpression();}
	:
	a=ID{ pexp.params.add($a.text);} (',' b=ID{ pexp.params.add($b.text);})* 
	;
// $>
// $<BASIC ELEMENT
stringelement returns[StringElement se]
	@init{se=new StringElement();}
	:	'"' a=ID '"' {se.content=$a.text;}
	;
// $>
