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

//rules begin

fileDeclaration returns[FileDeclaration rtn]
@init{rtn=new FileDeclaration();}
	:^(FILEDEC ((a=annotations{rtn.setAnnoations(a);})? p=packageDeclaration{rtn.setPackageDeclaration(p);})? (i=importDeclaration{rtn.addImportDeclaration(i);})* (t=typeDeclaration{rtn.addTypeDeclaration(t);})*)
	;

packageDeclaration returns[PackageDeclaration rtn]
@init{rtn=new PackageDeclaration();}
    :   ^('package' q=qualifiedName{rtn.setQualifiedName(q);})
    ;

importDeclaration returns[ImportDeclaration rtn]
@init{rtn=new ImportDeclaration();}
    :   ^('import' STATIC? qualifiedName DOTSTAR?)
    ;

typeDeclaration returns[TypeDeclaration rtn]
@init{rtn=new TypeDeclaration();}
    :   classOrInterfaceDeclaration
    ;

classOrInterfaceDeclaration 
    :   classDeclaration
    |   interfaceDeclaration
    ;


modifiers  
    : 	(modifier)*
    ;
modifier
    :	 annotation
    |   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    ;

variableModifiers 
    :   (variableModifier)*
    ;

variableModifier
	:	annotation 
	|	'final'
	;

classDeclaration 
    :   normalClassDeclaration
    |   enumDeclaration
    ;

normalClassDeclaration 
    :  ^('class' modifiers IDENTIFIER typeParameters? type? typeList? classBody)
    ;


typeParameters 
    :   ^('<' typeParameter  typeParameter* )
    ;

typeParameter 
    :  ^(TYPEPARAMETER IDENTIFIER typeBound?)
    ;

typeBound 
    :   ^(TYPEBOUND type  type*)
    ;


enumDeclaration 
    :   ^('enum' modifiers IDENTIFIER typeList? enumBody)
    ;
    

enumBody 
    :   ^('{' enumConstants? COMMA? enumBodyDeclarations?)
    ;

enumConstants 
    :   ^(ENUMCONSTANTS enumConstant enumConstant* )
    ;


enumConstant 
    :   ^(ENUMCONSTANT annotations? IDENTIFIER arguments? classBody?)
    ;

enumBodyDeclarations 
    :   ';' (classBodyDeclaration )*
    ;

interfaceDeclaration 
    :   normalInterfaceDeclaration
    |   annotationTypeDeclaration
    ;
    
normalInterfaceDeclaration 
    :   ^('interface'modifiers IDENTIFIER typeParameters? typeList? interfaceBody)
    ;

typeList 
    :   ^(TYPELIST type type*)
    ;

classBody 
    :   '{' (classBodyDeclaration)* '}'
    ;

interfaceBody 
    :   '{' (interfaceBodyDeclaration )* '}'
    ;

classBodyDeclaration 
    :   ';'
    |   (STATIC)? block
    |   memberDecl
    ;

memberDecl 
    :    fieldDeclaration
    |    methodDeclaration
    |    classDeclaration
    |    interfaceDeclaration
    ;


methodDeclaration 
    :
        modifiers (typeParameters)? IDENTIFIER formalParameters ('throws' qualifiedNameList)? '{' 
         	(explicitConstructorInvocation)? (blockStatement)* '}'
    |   modifiers (typeParameters)? (type|'void') IDENTIFIER formalParameters ('[' ']')* ('throws' qualifiedNameList)? 
    	 ( block |   ';'   )
    ;


fieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
    ;

variableDeclarator 
    :   IDENTIFIER ('[' ']')* ('=' variableInitializer)?
    ;

interfaceBodyDeclaration 
    :
        interfaceFieldDeclaration
    |   interfaceMethodDeclaration
    |   interfaceDeclaration
    |   classDeclaration
    |   ';'
    ;

interfaceMethodDeclaration 
    :   modifiers (typeParameters)? (type|'void') IDENTIFIER formalParameters ('[' ']')* ('throws' qualifiedNameList)? ';'
    ;

interfaceFieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
    ;


type 
    :   classOrInterfaceType BRACKETS*
    |   primitiveType BRACKETS*
    ;


classOrInterfaceType 
    :   IDENTIFIER (typeArguments)? ('.' IDENTIFIER (typeArguments)? )*
    ;

primitiveType  
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    ;

typeArguments 
    :   ^('<' typeArgument typeArgument*)
    ;

typeArgument 
    :   type
    |   '?' ( ('extends'|'super') type )?
    ;

qualifiedNameList 
    :    (',' qualifiedName)*
    ;

formalParameters 
    :   '('formalParameterDecls? ')'
    ;

formalParameterDecls 
    :   ellipsisParameterDecl
    |  ^(FORMALPARAMETERDECLS normalParameterDecl normalParameterDecl*)
    |  ^(FORMALPARAMETERDECLS normalParameterDecl+ ellipsisParameterDecl)
    ;

normalParameterDecl 
    :   variableModifiers type IDENTIFIER BRACKETS*
    ;

ellipsisParameterDecl 
    :   variableModifiers type  '...' IDENTIFIER
    ;


explicitConstructorInvocation 
    :   (nonWildcardTypeArguments)? ('this'|'super') arguments ';' 
    |   primary '.' (nonWildcardTypeArguments)? 'super' arguments ';'
    ;

qualifiedName returns[QualifiedName rtn]
@init{rtn=new QualifiedName();}
    :   (IDENTIFIER{rtn.addIdentifier($IDENTIFIER.text);})+
    ;

annotations returns[Annotations rtn]
@init{rtn=new Annotations();}
    :   annotation+
    ;


annotation 
    :   ^('@' qualifiedName elementOfAnno?)
    ;

elementOfAnno
	:	elementValuePairs 
	|	elementValue
	;

elementValuePairs 
    :   elementValuePair (',' elementValuePair)*
    ;

elementValuePair 
    :   ^('=' IDENTIFIER elementValue)
    ;

elementValue 
    :   conditionalExpression
    |   annotation
    |   elementValueArrayInitializer
    ;

elementValueArrayInitializer 
    :   ^('{' (elementValue elementValue+)? COMMA?)
    ;



annotationTypeDeclaration 
    :   ^('@' modifiers IDENTIFIER annotationTypeBody)
    ;


annotationTypeBody 
    :   '{' annotationTypeElementDeclaration* '}'
    ;


annotationTypeElementDeclaration 
    :   annotationMethodDeclaration
    |   interfaceFieldDeclaration
    |   normalClassDeclaration
    |   normalInterfaceDeclaration
    |   enumDeclaration
    |   annotationTypeDeclaration
    |   ';'
    ;

annotationMethodDeclaration 
    :  ^(ANNOMETHODDEC modifiers type IDENTIFIER elementValue?)
    ;

block 
    :   '{' blockStatement* '}'
    ;

blockStatement 
    :   localVariableDeclarationStatement
    |   classOrInterfaceDeclaration
    |   statement
    ;


localVariableDeclarationStatement 
    :   localVariableDeclaration ';'
    ;

localVariableDeclaration 
    :   variableModifiers type variableDeclarator (',' variableDeclarator)*
    ;

statement 
    :   block
    |   ^('assert' expression expression?)        
    |   ^('if' parExpression statement statement?)       
    |   forstatement
    |   ^('while' parExpression statement)
    |   ^('do' statement parExpression)
    |   trystatement
    |   ^('switch' parExpression switchBlockStatementGroups)
    |   ^('synchronized' parExpression block)
    |   'return' expression? ';'
    |   'throw' expression ';'
    |   'break' IDENTIFIER? ';'
    |   'continue'IDENTIFIER? ';'
    |   expression  ';'     
    |   IDENTIFIER ':' statement
    |   ';'
    ;

switchBlockStatementGroups 
    :   switchBlockStatementGroup*
    ;

switchBlockStatementGroup 
    :   switchLabel blockStatement*
    ;

switchLabel 
    :   CASE expression ':'
    |   DEFAULT ':'
    ;


trystatement 
    :   'try' block
        (   catches 'finally' block
        |   catches
        |   'finally' block
        )
     ;

catches 
    :   catchClause+
    ;

catchClause 
    :   'catch' '(' formalParameter ')' block 
    ;

formalParameter 
    :   variableModifiers type IDENTIFIER ('[' ']')*
    ;

forstatement 
    :   ^('for' variableModifiers type IDENTIFIER expression statement)
    |   ^('for' forInit? expression? expressionList? statement)
    ;

forInit 
    :   localVariableDeclaration
    |   expressionList
    ;

parExpression 
    :   '(' expression ')'
    ;

expressionList 
    :   expression (',' expression)*
    ;


expression 
    :   conditionalExpression (assignmentOperator expression)?
    ;


assignmentOperator 
    :   '='
    |   '+='
    |   '-='
    |   '*='
    |   '/='
    |   '&='
    |   '|='
    |   '^='
    |   '%='
    |    '<' '<' '='
    |    '>' '>' '>' '='
    |    '>' '>' '='
    ;


conditionalExpression 
    :   ^(CONDITIONALEXP conditionalOrExpression ( expression conditionalExpression)?)
    ;

conditionalOrExpression 
    :   conditionalAndExpression ('||' conditionalAndExpression)*
    ;

conditionalAndExpression 
    :   inclusiveOrExpression ('&&' inclusiveOrExpression)*
    ;

inclusiveOrExpression 
    :   exclusiveOrExpression ('|' exclusiveOrExpression)*
    ;

exclusiveOrExpression 
    :   andExpression ('^' andExpression)*
    ;

andExpression 
    :   equalityExpression ('&' equalityExpression)*
    ;

equalityExpression 
    :   instanceOfExpression (   ('=='|'!=') instanceOfExpression)*
    ;

instanceOfExpression 
    :   relationalExpression ('instanceof' type )?
    ;

relationalExpression 
    :   shiftExpression (relationalOp shiftExpression)*
    ;

relationalOp 
    :   '<' '='
    |   '>' '='
    |   '<'
    |   '>'
    ;

shiftExpression 
    :   additiveExpression (shiftOp additiveExpression)*
    ;


shiftOp 
    :    '<' '<'
    |    '>' '>' '>'
    |    '>' '>'
    ;


additiveExpression 
    :   multiplicativeExpression (   ('+'|'-') multiplicativeExpression)*
    ;

multiplicativeExpression 
    :
        unaryExpression (   ('*'|'/'|'%') unaryExpression)*
    ;


unaryExpression 
    :   '+'  unaryExpression
    |   '-' unaryExpression
    |   '++' unaryExpression
    |   '--' unaryExpression
    |   unaryExpressionNotPlusMinus
    ;

unaryExpressionNotPlusMinus 
    :   '~' unaryExpression
    |   '!' unaryExpression
    |   castExpression
    |   primary (selector)* ('++'|'--')?
    ;

castExpression 
    :   ^('(' primitiveType unaryExpression)
    |   ^('(' type unaryExpressionNotPlusMinus)
    ;


primary 
    :   parExpression            
    |   ^('this' IDENTIFIER* identifierSuffix?)
    |   ^(PRIMARY IDENTIFIER+ identifierSuffix?)
    |   'super' superSuffix
    |   literal
    |   creator
    |   primitiveType (BRACKETS)* '.' 'class'
    |   'void' '.' 'class'
    ;
    

superSuffix  
    :   arguments
    |   '.' (typeArguments)? IDENTIFIER (arguments)?
    ;


identifierSuffix 
    :   ('[' ']')+ '.' 'class'
    |   ('[' expression ']' )+
    |   arguments
    |   '.' 'class'
    |   '.' nonWildcardTypeArguments IDENTIFIER arguments
    |   '.' 'this'
    |   '.' 'super' arguments
    |   innerCreator
    ;


selector  
    :   '.' IDENTIFIER (arguments)?
    |   '.' 'this'
    |   '.' 'super' superSuffix
    |   innerCreator
    |   '[' expression ']'
    ;

creator 
    :   ^('new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest)
    |   ^('new' classOrInterfaceType classCreatorRest)
    |   arrayCreator
    ;

arrayCreator 
    :   ^('new' createdName BRACKETS+ arrayInitializer)
    |   ^('new' createdName expression+ BRACKETS*)
    ;

variableInitializer 
    :   arrayInitializer
    |   expression
    ;

arrayInitializer 
    :   ^('{' variableInitializer+ COMMA?)
    ;


createdName 
    :   classOrInterfaceType
    |   primitiveType
    ;

innerCreator  
    :   ^('.' nonWildcardTypeArguments? IDENTIFIER typeArguments? classCreatorRest)
    ;


classCreatorRest 
    :   arguments (classBody)?
    ;


nonWildcardTypeArguments 
    :   '<' typeList '>'
    ;

arguments 
    :   '(' (expressionList)? ')'
    ;

literal 
    :   INTLITERAL
    |   LONGLITERAL
    |   FLOATLITERAL
    |   DOUBLELITERAL
    |   CHARLITERAL
    |   STRINGLITERAL
    |   TRUE
    |   FALSE
    |   NULL
    ;
//rules end
