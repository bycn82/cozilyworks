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

// START:decl
program returns[Program p]
@init{ p=new Program();}
    :   (a=declaration{p.addDeclaration(a);})+
    ;

declaration returns[Declaration dec]
    :   d=variable{dec=new Declaration(d);}
    |   f=function{dec=new Declaration(f);}
    ;

variable returns[Variable v]
    :   ^(VAR t=type id=ID)
        {v=new Variable(t,$id.text);}
    ;

type returns[String t]
    :   'int' {t="int";}
    |   'char'{t="char";}
    ;

function returns[Function f]
@init{f=new Function();}
    :   ^(FUNC s=type{f.setType(s);} ID{f.setId($ID.text);}
     (fp=formalParameter{f.addFormalParameter(fp);})* b=block{f.setBlock(b);})
    ;

formalParameter returns[FormalParameter f]
@init{f=new FormalParameter();}
    :   ^(ARG t=type{f.setType(t);} ID{f.setId($ID.text);})
    ;
// END:decl

// START:stat
block returns[Block b]
@init{b=new Block();}
    :   ^(SLIST (v=variable{b.addVariable(v);})* (s=stat{b.addStat(s);})*)
    ;

stat returns[Stat s]
@init{s=new Stat();}
    : fs=forStat{s.setForStat(fs);}
    | ex=expr{s.setExpr(ex);}
    | b=block{s.setBlock(b);}
    | as=assignStat{s.setAssignStat(as);}
    ;

forStat returns[ForStat fs]
@init{fs=new ForStat();}
    :   ^('for' a=assignStat{fs.addAssignStat(a);} e=expr{fs.setExpr(e);}
     b= assignStat{fs.addAssignStat(b);} bl=block{fs.setBlock(bl);})
    ;

assignStat returns[AssignStat as]
@init{as=new AssignStat();}
    :   ^('=' ID{as.setID($ID.text);} e=expr{as.setExpr(e);})
    ;
// END:stat

// START:expr
expr returns[Expr e]
@init{e=new Expr();}
    :   ^(
    ('=='{e.setMethod("==");}    
    |'!='{e.setMethod("!=");}
    |'+'{e.setMethod("+");}
    |'*'{e.setMethod("*");}
    ) 
    a=expr{e.addExpr(a);} b=expr{e.addExpr(b);})
    |   ID {e.setId($ID.text);}
    |   INT{e.setInt($INT.text);}
    ;
// END:expr

    
    