grammar Cozily;
options {
	memoize=true;
	backtrack=true;
	output=AST;
	ASTLabelType=CommonTree;
}
tokens{
	VAR;
	FILEDEC;
	PACKAGEDEC;
	TYPEPARAMETER;
	TYPEBOUND;
	ENUMCONSTANTS;
	ENUMCONSTANT;
	TYPELIST;
	CLASSBODY;
	FORMALPARAMETERDECLS;
}
@header {
package com.cozilyworks.cozily.parser;
}
@lexer::header {
package com.cozilyworks.cozily.parser;
import com.cozilyworks.cozily.codedom.*;
import com.cozilyworks.cozily.codedom.impl.*;
}
//rules begin
           
fileDeclaration 
	:	(annotations? packageDeclaration)? importDeclaration* typeDeclaration* 
->^(FILEDEC (annotations? packageDeclaration)? importDeclaration* typeDeclaration*)
	;

packageDeclaration 
    :   'package' qualifiedName ';'
->^('package' qualifiedName)
    ;

importDeclaration  
    :   'import' STATIC? qualifiedName DOTSTAR? ';'
->^('import' STATIC? qualifiedName DOTSTAR?)
    ;

typeDeclaration 
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
    :   modifiers  'class' IDENTIFIER (typeParameters)? ('extends' type)? ('implements' typeList )? classBody
->^('class' modifiers IDENTIFIER typeParameters? type? typeList? classBody)
    ;


typeParameters 
    :   '<' typeParameter (',' typeParameter)* '>'
->^('<' typeParameter  typeParameter* )
    ;

typeParameter 
    :   IDENTIFIER ('extends' typeBound )?
->^(TYPEPARAMETER IDENTIFIER typeBound?)
    ;

typeBound 
    :   type ('&' type)*
->^(TYPEBOUND type  type*)
    ;


enumDeclaration 
    :   modifiers 'enum' IDENTIFIER ('implements' typeList )? enumBody
->^('enum' modifiers IDENTIFIER typeList? enumBody)
    ;
    

enumBody 
    :   '{' (enumConstants)? COMMA? (enumBodyDeclarations)? '}'
->^('{' enumConstants? COMMA? enumBodyDeclarations?)
    ;

enumConstants 
    :   enumConstant (',' enumConstant)*
->^(ENUMCONSTANTS enumConstant enumConstant* )
    ;


enumConstant 
    :   (annotations)? IDENTIFIER (arguments)? (classBody)?
->^(ENUMCONSTANT annotations? IDENTIFIER arguments? classBody?)
    ;

enumBodyDeclarations 
    :   ';' (classBodyDeclaration )*
    ;

interfaceDeclaration 
    :   normalInterfaceDeclaration
    |   annotationTypeDeclaration
    ;
    
normalInterfaceDeclaration 
    :   modifiers 'interface' IDENTIFIER (typeParameters)?  ('extends' typeList)? interfaceBody
->^('interface'modifiers IDENTIFIER typeParameters? typeList? interfaceBody)
    ;

typeList 
    :   type (',' type)*
->^(TYPELIST type type*)
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
    :   classOrInterfaceType ('[' ']')*
    |   primitiveType ('[' ']')*
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
    :   '<' typeArgument (',' typeArgument)* '>'
->^('<' typeArgument typeArgument*)
    ;

typeArgument 
    :   type
    |   '?' ( ('extends'|'super') type )?
    ;

qualifiedNameList 
    :    (',' qualifiedName)*
    ;

formalParameters 
    :   '('(formalParameterDecls)? ')'
    ;

formalParameterDecls 
    :   ellipsisParameterDecl
    |   normalParameterDecl (',' normalParameterDecl)*
->^(FORMALPARAMETERDECLS normalParameterDecl normalParameterDecl*)
    |   (normalParameterDecl ',')+ ellipsisParameterDecl
->^(FORMALPARAMETERDECLS normalParameterDecl+ ellipsisParameterDecl)
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

qualifiedName 
    :   IDENTIFIER ('.' IDENTIFIER)*
    ;

annotations 
    :   (annotation)+
    ;


annotation 
    :   '@' qualifiedName (   '(' (elementOfAnno)?  ')' )?
    ;

elementOfAnno
	:	elementValuePairs 
	|	elementValue
	;

elementValuePairs 
    :   elementValuePair (',' elementValuePair)*
    ;

elementValuePair 
    :   IDENTIFIER '=' elementValue
    ;

elementValue 
    :   conditionalExpression
    |   annotation
    |   elementValueArrayInitializer
    ;

elementValueArrayInitializer 
    :   '{'(elementValue  (',' elementValue)*  )? (',')? '}'
    ;



annotationTypeDeclaration 
    :   modifiers '@' 'interface' IDENTIFIER annotationTypeBody
    ;


annotationTypeBody 
    :   '{' (annotationTypeElementDeclaration)* '}'
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
    :   modifiers type IDENTIFIER '(' ')' ('default' elementValue)? ';'
    ;

block 
    :   '{'(blockStatement)* '}'
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
    |   ('assert') expression (':' expression)? ';'
    |   'assert'  expression (':' expression)? ';'            
    |   'if' parExpression statement ('else' statement)?          
    |   forstatement
    |   'while' parExpression statement
    |   'do' statement 'while' parExpression ';'
    |   trystatement
    |   'switch' parExpression '{' switchBlockStatementGroups '}'
    |   'synchronized' parExpression block
    |   'return' (expression )? ';'
    |   'throw' expression ';'
    |   'break' (IDENTIFIER)? ';'
    |   'continue'(IDENTIFIER)? ';'
    |   expression  ';'     
    |   IDENTIFIER ':' statement
    |   ';'
    ;

switchBlockStatementGroups 
    :   (switchBlockStatementGroup )*
    ;

switchBlockStatementGroup 
    :   switchLabel (blockStatement )*
    ;

switchLabel 
    :   'case' expression ':'
    |   'default' ':'
    ;


trystatement 
    :   'try' block
        (   catches 'finally' block
        |   catches
        |   'finally' block
        )
     ;

catches 
    :   catchClause (catchClause )*
    ;

catchClause 
    :   'catch' '(' formalParameter ')' block 
    ;

formalParameter 
    :   variableModifiers type IDENTIFIER ('[' ']')*
    ;

forstatement 
    :   'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
    |   'for' '(' (forInit)? ';' (expression)? ';' (expressionList)? ')' statement
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
    :   conditionalOrExpression ('?' expression ':' conditionalExpression)?
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
    :   '(' primitiveType ')' unaryExpression
    |   '(' type ')' unaryExpressionNotPlusMinus
    ;


primary 
    :   parExpression            
    |   'this' ('.' IDENTIFIER)* (identifierSuffix)?
    |   IDENTIFIER ('.' IDENTIFIER)* (identifierSuffix)?
    |   'super' superSuffix
    |   literal
    |   creator
    |   primitiveType ('[' ']')* '.' 'class'
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
    :   'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
    |   'new' classOrInterfaceType classCreatorRest
    |   arrayCreator
    ;

arrayCreator 
    :   'new' createdName '[' ']' ('[' ']')* arrayInitializer
    |   'new' createdName '[' expression ']' (   '[' expression ']')* ('[' ']' )*
    ;

variableInitializer 
    :   arrayInitializer
    |   expression
    ;

arrayInitializer 
    :   '{' (variableInitializer (',' variableInitializer )* )? (',')? '}' 
    ;


createdName 
    :   classOrInterfaceType
    |   primitiveType
    ;

innerCreator  
    :   '.' 'new' (nonWildcardTypeArguments)? IDENTIFIER (typeArguments)?  classCreatorRest
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



//tokensbegin

LONGLITERAL
    :   IntegerNumber LongSuffix
    ;  
INTLITERAL
    :   IntegerNumber 
    ;
fragment
IntegerNumber
    :   '0' 
    |   '1'..'9' ('0'..'9')*    
    |   '0' ('0'..'7')+         
    |   HexPrefix HexDigit+        
    ;
fragment
HexPrefix
    :   '0x' | '0X'
    ;     
fragment
HexDigit
    :   ('0'..'9'|'a'..'f'|'A'..'F')
    ;
fragment
LongSuffix
    :   'l' | 'L'
    ;
fragment
NonIntegerNumber
    :   ('0' .. '9')+ '.' ('0' .. '9')* Exponent?  
    |   '.' ( '0' .. '9' )+ Exponent?  
    |   ('0' .. '9')+ Exponent  
    |   ('0' .. '9')+ 
    |   
        HexPrefix (HexDigit )* 
        (    () 
        |    ('.' (HexDigit )* ) 
        ) 
        ( 'p' | 'P' ) 
        ( '+' | '-' )? 
        ( '0' .. '9' )+
        ;       
fragment 
Exponent    
    :   ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ 
    ;   
fragment 
FloatSuffix
    :   'f' | 'F' 
    ;     
fragment
DoubleSuffix
    :   'd' | 'D'
    ;      
FLOATLITERAL
    :   NonIntegerNumber FloatSuffix
    ;   
DOUBLELITERAL
    :   NonIntegerNumber DoubleSuffix?
    ;
CHARLITERAL
    :   '\'' 
        (   EscapeSequence 
        |   ~( '\'' | '\\' | '\r' | '\n' )
        ) 
        '\''
    ; 
STRINGLITERAL
    :   '"' 
        (   EscapeSequence
        |   ~( '\\' | '"' | '\r' | '\n' )        
        )* 
        '"' 
    ;
fragment
EscapeSequence 
    :   '\\' (
                 'b' 
             |   't' 
             |   'n' 
             |   'f' 
             |   'r' 
             |   '\"' 
             |   '\'' 
             |   '\\' 
             |       
                 ('0'..'3') ('0'..'7') ('0'..'7')
             |       
                 ('0'..'7') ('0'..'7') 
             |       
                 ('0'..'7')
             )          
;     
WS  
    :   (
             ' '
        |    '\r'
        |    '\t'
        |    '\u000C'
        |    '\n'
        ) {skip();}          
    ;    
COMMENT
    :   '/*'
	//TODO
        '*/'{skip();}
    ;
LINE_COMMENT
    :   '//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') {skip();}
    |   '//' ~('\n'|'\r')* {skip();}
    ;           
ABSTRACT
    :   'abstract'
    ;    
ASSERT
    :   'assert'
    ;    
BOOLEAN
    :   'boolean'
    ;    
BREAK
    :   'break'
    ;    
BYTE
    :   'byte'
    ;    
CASE
    :   'case'
    ;    
CATCH
    :   'catch'
    ;    
CHAR
    :   'char'
    ;
CLASS
    :   'class'
    ;
CONST
    :   'const'
    ;
CONTINUE
    :   'continue'
    ;

DEFAULT
    :   'default'
    ;

DO
    :   'do'
    ;

DOUBLE
    :   'double'
    ;

ELSE
    :   'else'
    ;

ENUM
    :   'enum'
    ;             

EXTENDS
    :   'extends'
    ;

FINAL
    :   'final'
    ;

FINALLY
    :   'finally'
    ;

FLOAT
    :   'float'
    ;

FOR
    :   'for'
    ;

GOTO
    :   'goto'
    ;

IF
    :   'if'
    ;

IMPLEMENTS
    :   'implements'
    ;

IMPORT
    :   'import'
    ;

INSTANCEOF
    :   'instanceof'
    ;

INT
    :   'int'
    ;

INTERFACE
    :   'interface'
    ;

LONG
    :   'long'
    ;

NATIVE
    :   'native'
    ;

NEW
    :   'new'
    ;

PACKAGE
    :   'package'
    ;

PRIVATE
    :   'private'
    ;

PROTECTED
    :   'protected'
    ;

PUBLIC
    :   'public'
    ;

RETURN
    :   'return'
    ;

SHORT
    :   'short'
    ;

STATIC
    :   'static'
    ;

STRICTFP
    :   'strictfp'
    ;

SUPER
    :   'super'
    ;

SWITCH
    :   'switch'
    ;

SYNCHRONIZED
    :   'synchronized'
    ;

THIS
    :   'this'
    ;

THROW
    :   'throw'
    ;

THROWS
    :   'throws'
    ;

TRANSIENT
    :   'transient'
    ;

TRY
    :   'try'
    ;

VOID
    :   'void'
    ;

VOLATILE
    :   'volatile'
    ;

WHILE
    :   'while'
    ;

TRUE
    :   'true'
    ;

FALSE
    :   'false'
    ;

NULL
    :   'null'
    ;

LPAREN
    :   '('
    ;

RPAREN
    :   ')'
    ;

LBRACE
    :   '{'
    ;

RBRACE
    :   '}'
    ;
    
BRACKETS
	:	'[' ']'
	;
	
LBRACKET
    :   '['
    ;

RBRACKET
    :   ']'
    ;
   
SEMI
    :   ';'
    ;

COMMA
    :   ','
    ;
    
DOTSTAR
	:	'.*'
	;
	
DOT
    :   '.'
    ;

ELLIPSIS
    :   '...'
    ;

EQ
    :   '='
    ;

BANG
    :   '!'
    ;

TILDE
    :   '~'
    ;

QUES
    :   '?'
    ;

COLON
    :   ':'
    ;

EQEQ
    :   '=='
    ;

AMPAMP
    :   '&&'
    ;

BARBAR
    :   '||'
    ;

PLUSPLUS
    :   '++'
    ;

SUBSUB
    :   '--'
    ;

PLUS
    :   '+'
    ;

SUB
    :   '-'
    ;

STAR
    :   '*'
    ;

SLASH
    :   '/'
    ;

AMP
    :   '&'
    ;

BAR
    :   '|'
    ;

CARET
    :   '^'
    ;

PERCENT
    :   '%'
    ;

PLUSEQ
    :   '+='
    ; 
    
SUBEQ
    :   '-='
    ;

STAREQ
    :   '*='
    ;

SLASHEQ
    :   '/='
    ;

AMPEQ
    :   '&='
    ;

BAREQ
    :   '|='
    ;

CARETEQ
    :   '^='
    ;

PERCENTEQ
    :   '%='
    ;

MONKEYS_AT
    :   '@'
    ;

BANGEQ
    :   '!='
    ;

GT
    :   '>'
    ;

LT
    :   '<'
    ;        
              
IDENTIFIER
    :   IdentifierStart IdentifierPart*
    ;

fragment
SurrogateIdentifer 
    :   ('\ud800'..'\udbff') ('\udc00'..'\udfff') 
    ;                 

fragment
IdentifierStart
    :   '\u0024'
    |   '\u0041'..'\u005a'
    |   '\u005f'
    |   '\u0061'..'\u007a'
    ;                
                       
fragment 
IdentifierPart
    :   '\u0024'
    |   '\u0030'..'\u0039'
    |   '\u0041'..'\u005a'
    |   '\u005f'
    |   '\u0061'..'\u007a'
    ;

