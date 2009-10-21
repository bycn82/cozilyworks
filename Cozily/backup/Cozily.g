grammar Cozily;
options {
	memoize=true;
	backtrack=true;
	output=AST;
	ASTLabelType=CommonTree;
}
tokens{
VAR;
FILEDECLARATION0;
PACKAGEDECLARATION0;
IMPORTDECLARATION0;
TYPEDECLARATION0;
CLASSORINTERFACEDECLARATION0;
CLASSORINTERFACEDECLARATION1;
MODIFIERS0;
MODIFIER0;
MODIFIER1;
MODIFIER2;
MODIFIER3;
MODIFIER4;
MODIFIER5;
MODIFIER6;
MODIFIER7;
MODIFIER8;
MODIFIER9;
MODIFIER10;
MODIFIER11;
VARIABLEMODIFIERS0;
VARIABLEMODIFIER0;
VARIABLEMODIFIER1;
CLASSDECLARATION0;
CLASSDECLARATION1;
NORMALCLASSDECLARATION0;
TYPEPARAMETERS0;
TYPEPARAMETER0;
TYPEBOUND0;
ENUMDECLARATION0;
ENUMBODY0;
ENUMCONSTANTS0;
ENUMCONSTANT0;
ENUMBODYDECLARATIONS0;
INTERFACEDECLARATION0;
INTERFACEDECLARATION1;
NORMALINTERFACEDECLARATION0;
TYPELIST0;
CLASSBODY0;
INTERFACEBODY0;
CLASSBODYDECLARATION0;
CLASSBODYDECLARATION1;
CLASSBODYDECLARATION2;
MEMBERDECL0;
MEMBERDECL1;
MEMBERDECL2;
MEMBERDECL3;
METHODDECLARATION0;
METHODDECLARATION1;
BLOCKORCOMMA0;
BLOCKORCOMMA1;
RETURNTYPE0;
RETURNTYPE1;
FIELDDECLARATION0;
VARIABLEDECLARATOR0;
INTERFACEBODYDECLARATION0;
INTERFACEBODYDECLARATION1;
INTERFACEBODYDECLARATION2;
INTERFACEBODYDECLARATION3;
INTERFACEBODYDECLARATION4;
INTERFACEMETHODDECLARATION0;
INTERFACEFIELDDECLARATION0;
TYPE0;
TYPE1;
CLASSORINTERFACETYPE0;
PRIMITIVETYPE0;
PRIMITIVETYPE1;
PRIMITIVETYPE2;
PRIMITIVETYPE3;
PRIMITIVETYPE4;
PRIMITIVETYPE5;
PRIMITIVETYPE6;
PRIMITIVETYPE7;
TYPEARGUMENTS0;
TYPEARGUMENT0;
TYPEARGUMENT1;
EXTENDSORSUPER0;
EXTENDSORSUPER1;
QUALIFIEDNAMELIST0;
FORMALPARAMETERS0;
FORMALPARAMETERDECLS0;
FORMALPARAMETERDECLS1;
FORMALPARAMETERDECLS2;
NORMALPARAMETERDECL0;
ELLIPSISPARAMETERDECL0;
EXPLICITCONSTRUCTORINVOCATION0;
EXPLICITCONSTRUCTORINVOCATION1;
THISORSUPER0;
THISORSUPER1;
QUALIFIEDNAME0;
ANNOTATIONS0;
ANNOTATION0;
ELEMENTOFANNO0;
ELEMENTOFANNO1;
ELEMENTVALUEPAIRS0;
ELEMENTVALUEPAIR0;
ELEMENTVALUE0;
ELEMENTVALUE1;
ELEMENTVALUE2;
ELEMENTVALUEARRAYINITIALIZER0;
ANNOTATIONTYPEDECLARATION0;
ANNOTATIONTYPEBODY0;
ANNOTATIONTYPEELEMENTDECLARATION0;
ANNOTATIONTYPEELEMENTDECLARATION1;
ANNOTATIONTYPEELEMENTDECLARATION2;
ANNOTATIONTYPEELEMENTDECLARATION3;
ANNOTATIONTYPEELEMENTDECLARATION4;
ANNOTATIONTYPEELEMENTDECLARATION5;
ANNOTATIONTYPEELEMENTDECLARATION6;
ANNOTATIONMETHODDECLARATION0;
BLOCK0;
BLOCKSTATEMENT0;
BLOCKSTATEMENT1;
BLOCKSTATEMENT2;
LOCALVARIABLEDECLARATIONSTATEMENT0;
LOCALVARIABLEDECLARATION0;
STATEMENT0;
STATEMENT1;
STATEMENT2;
STATEMENT3;
STATEMENT4;
STATEMENT5;
STATEMENT6;
STATEMENT7;
STATEMENT8;
STATEMENT9;
STATEMENT10;
STATEMENT11;
STATEMENT12;
STATEMENT13;
STATEMENT14;
STATEMENT15;
SWITCHBLOCKSTATEMENTGROUPS0;
SWITCHBLOCKSTATEMENTGROUP0;
SWITCHLABEL0;
SWITCHLABEL1;
TRYSTATEMENT0;
TRYSTATEMENT1;
TRYSTATEMENT2;
CATCHES0;
CATCHCLAUSE0;
FORMALPARAMETER0;
FORSTATEMENT0;
FORSTATEMENT1;
FORINIT0;
FORINIT1;
PAREXPRESSION0;
EXPRESSIONLIST0;
EXPRESSION0;
ASSIGNMENTOPERATOR0;
ASSIGNMENTOPERATOR1;
ASSIGNMENTOPERATOR2;
ASSIGNMENTOPERATOR3;
ASSIGNMENTOPERATOR4;
ASSIGNMENTOPERATOR5;
ASSIGNMENTOPERATOR6;
ASSIGNMENTOPERATOR7;
ASSIGNMENTOPERATOR8;
ASSIGNMENTOPERATOR9;
ASSIGNMENTOPERATOR10;
ASSIGNMENTOPERATOR11;
CONDITIONALEXPRESSION0;
CONDITIONALOREXPRESSION0;
CONDITIONALANDEXPRESSION0;
INCLUSIVEOREXPRESSION0;
EXCLUSIVEOREXPRESSION0;
ANDEXPRESSION0;
EQUALITYEXPRESSION0;
EQUALORNOTEQUAL0;
EQUALORNOTEQUAL1;
INSTANCEOFEXPRESSION0;
RELATIONALEXPRESSION0;
RELATIONALOP0;
RELATIONALOP1;
RELATIONALOP2;
RELATIONALOP3;
SHIFTEXPRESSION0;
SHIFTOP0;
SHIFTOP1;
SHIFTOP2;
ADDITIVEEXPRESSION0;
PLUSORMINUS0;
PLUSORMINUS1;
MULTIPLICATIVEEXPRESSION0;
TIMESDIVIDE0;
TIMESDIVIDE1;
TIMESDIVIDE2;
UNARYEXPRESSION0;
UNARYEXPRESSION1;
UNARYEXPRESSION2;
UNARYEXPRESSION3;
UNARYEXPRESSION4;
UNARYEXPRESSIONNOTPLUSMINUS0;
UNARYEXPRESSIONNOTPLUSMINUS1;
UNARYEXPRESSIONNOTPLUSMINUS2;
UNARYEXPRESSIONNOTPLUSMINUS3;
DOUBLEPLUSMINUS0;
DOUBLEPLUSMINUS1;
CASTEXPRESSION0;
CASTEXPRESSION1;
PRIMARY0;
PRIMARY1;
PRIMARY2;
PRIMARY3;
PRIMARY4;
PRIMARY5;
PRIMARY6;
PRIMARY7;
SUPERSUFFIX0;
SUPERSUFFIX1;
IDENTIFIERSUFFIX0;
IDENTIFIERSUFFIX1;
IDENTIFIERSUFFIX2;
IDENTIFIERSUFFIX3;
IDENTIFIERSUFFIX4;
IDENTIFIERSUFFIX5;
IDENTIFIERSUFFIX6;
IDENTIFIERSUFFIX7;
SELECTOR0;
SELECTOR1;
SELECTOR2;
SELECTOR3;
SELECTOR4;
CREATOR0;
CREATOR1;
CREATOR2;
ARRAYCREATOR0;
ARRAYCREATOR1;
VARIABLEINITIALIZER0;
VARIABLEINITIALIZER1;
ARRAYINITIALIZER0;
CREATEDNAME0;
CREATEDNAME1;
INNERCREATOR0;
CLASSCREATORREST0;
NONWILDCARDTYPEARGUMENTS0;
ARGUMENTS0;
LITERAL0;
LITERAL1;
LITERAL2;
LITERAL3;
LITERAL4;
LITERAL5;
LITERAL6;
LITERAL7;
LITERAL8;

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
	;

packageDeclaration 
    :   'package' qualifiedName ';'
    ;

importDeclaration  
    :   'import' STATIC? qualifiedName DOTSTAR? ';'
    ;

typeDeclaration 
    :   classOrInterfaceDeclaration
    ;

classOrInterfaceDeclaration 
    :   classDeclaration
    |   interfaceDeclaration
    ;


modifiers  
    : 	modifier*
    ;
modifier
    :	 annotation
    |   PUBLIC
    |   PROTECTED
    |   PRIVATE
    |   STATIC
    |   ABSTRACT
    |   FINAL
    |   NATIVE
    |   SYNCHRONIZED
    |   TRANSIENT
    |   VOLATILE
    |   STRICTFP
    ;

variableModifiers 
    :   variableModifier*
    ;

variableModifier
	:	annotation 
	|	FINAL
	;

classDeclaration 
    :   normalClassDeclaration
    |   enumDeclaration
    ;

normalClassDeclaration 
    :   modifiers  'class' IDENTIFIER typeParameters? ('extends' type)? ('implements' typeList)? classBody
    ;


typeParameters 
    :   '<' typeParameter (',' typeParameter)* '>'
    ;

typeParameter 
    :   IDENTIFIER ('extends' typeBound)?
    ;

typeBound 
    :   type ('&' type)*
    ;


enumDeclaration 
    :   modifiers 'enum' IDENTIFIER ('implements' typeList)? enumBody
    ;
    

enumBody 
    :   '{' enumConstants? COMMA? (enumBodyDeclarations)? '}'
    ;

enumConstants 
    :   enumConstant (',' enumConstant)*
    ;


enumConstant 
    :   annotations? IDENTIFIER arguments? classBody?
    ;

enumBodyDeclarations 
    :   ';' classBodyDeclaration*
    ;

interfaceDeclaration 
    :   normalInterfaceDeclaration
    |   annotationTypeDeclaration
    ;
    
normalInterfaceDeclaration 
    :   modifiers 'interface' IDENTIFIER typeParameters?  ('extends' typeList)? interfaceBody
    ;

typeList 
    :   type (',' type)*
    ;

classBody 
    :   '{' classBodyDeclaration* '}'
    ;

interfaceBody 
    :   '{' interfaceBodyDeclaration* '}'
    ;

classBodyDeclaration 
    :   ';'
    |   STATIC? block
    |   memberDecl
    ;

memberDecl 
    :    fieldDeclaration
    |    methodDeclaration
    |    classDeclaration
    |    interfaceDeclaration
    ;


methodDeclaration 
    :   modifiers typeParameters? IDENTIFIER formalParameters ('throws' qualifiedNameList)? '{' explicitConstructorInvocation? blockStatement* '}'
    |   modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? blockOrComma
    ;

blockOrComma
	:	block 
	|   SEMI  
	;

returnType
	:	type
	|	VOID
	;


fieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
    ;

variableDeclarator 
    :   IDENTIFIER BRACKETS* ('=' variableInitializer)?
    ;

interfaceBodyDeclaration 
    :   interfaceFieldDeclaration
    |   interfaceMethodDeclaration
    |   interfaceDeclaration
    |   classDeclaration
    |   SEMI
    ;

interfaceMethodDeclaration 
    :   modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? ';'
    ;

interfaceFieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
    ;


type 
    :   classOrInterfaceType BRACKETS*
    |   primitiveType BRACKETS*
    ;


classOrInterfaceType 
    :   IDENTIFIER typeArguments? ('.' IDENTIFIER typeArguments? )*
    ;

primitiveType  
    :   BOOLEAN
    |   CHAR
    |   BYTE
    |   SHORT
    |   INT
    |   LONG
    |   FLOAT
    |   DOUBLE
    ;

typeArguments 
    :   '<' typeArgument (',' typeArgument)* '>'
    ;

typeArgument 
    :   type
    |   '?' ( extendsOrSuper type )?
    ;

extendsOrSuper
	:	EXTENDS
	|	SUPER
	;

qualifiedNameList 
    :    (',' qualifiedName)*
    ;

formalParameters 
    :   '('formalParameterDecls? ')'
    ;

formalParameterDecls 
    :   ellipsisParameterDecl
    |   normalParameterDecl (',' normalParameterDecl)*
    |   (normalParameterDecl ',')+ ellipsisParameterDecl
    ;

normalParameterDecl 
    :   variableModifiers type IDENTIFIER BRACKETS*
    ;

ellipsisParameterDecl 
    :   variableModifiers type  '...' IDENTIFIER
    ;


explicitConstructorInvocation 
    :   nonWildcardTypeArguments? thisOrSuper arguments ';' 
    |   primary '.' nonWildcardTypeArguments? 'super' arguments ';'
    ;

thisOrSuper
	:	THIS
	|	SUPER
	;

qualifiedName 
    :   IDENTIFIER ('.' IDENTIFIER)*
    ;

annotations 
    :   annotation+
    ;


annotation 
    :   '@' qualifiedName (   LPAREN elementOfAnno?  RPAREN )?
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
    :   '{'(elementValue  (',' elementValue)*  )? COMMA? '}'
    ;



annotationTypeDeclaration 
    :   modifiers '@' 'interface' IDENTIFIER annotationTypeBody
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
    :   modifiers type IDENTIFIER '(' ')' ('default' elementValue)? ';'
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
    |   'assert'  expression (':' expression)? ';'    
    |   'if' parExpression statement ('else' statement)?      
    |   forstatement
    |   'while' parExpression statement
    |   'do' statement 'while' parExpression ';'
    |   trystatement
    |   'switch' parExpression '{' switchBlockStatementGroups '}'
    |   'synchronized' parExpression block
    |   'return' expression? ';'
    |   'throw' expression ';'
    |   'break' IDENTIFIER? ';'
    |   'continue'IDENTIFIER? ';'
    |   expression  ';'     
    |   IDENTIFIER ':' statement
    |   SEMI
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
    :   'try' block   catches 'finally' block
	| 'try' block  catches
    | 'try' block  'finally' block    
    ;

catches 
    :   catchClause+
    ;

catchClause 
    :   'catch' '(' formalParameter ')' block 
    ;

formalParameter 
    :   variableModifiers type IDENTIFIER BRACKETS*
    ;

forstatement 
    :   'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
    |   'for' '(' forInit? ';' expression? ';' expressionList? ')' statement
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
    :   EQ
    |   PLUSEQ
    |   SUBEQ
    |   STAREQ
    |   SLASHEQ
    |   AMPEQ
    |   BAREQ
    |   CARETEQ
    |   PERCENTEQ
    |   LT LT EQ
    |   GT GT GT EQ
    |   GT GT EQ
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
    :   instanceOfExpression ( equalOrNotequal instanceOfExpression)*
    ;

equalOrNotequal
	:	EQEQ
	|	BANGEQ
	;

instanceOfExpression 
    :   relationalExpression ('instanceof' type )?
    ;

relationalExpression 
    :   shiftExpression (relationalOp shiftExpression)*
    ;

relationalOp 
    :   LT EQ
    |   GT EQ
    |   LT
    |   GT
    ;

shiftExpression 
    :   additiveExpression (shiftOp additiveExpression)*
    ;


shiftOp 
    :    LT LT
    |    GT GT
    |    GT GT GT
    ;


additiveExpression 
    :   multiplicativeExpression ( plusOrMinus multiplicativeExpression)*
    ;

plusOrMinus
	:	PLUS
	|	SUB
	;

multiplicativeExpression 
    :	unaryExpression ( timesDivide unaryExpression)*
    ;

timesDivide
	:	STAR
	|	SLASH
	|	PERCENT
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
    |   primary selector* doublePlusMinus?
    ;

doublePlusMinus
	:	PLUSPLUS
	|	SUBSUB
	;

castExpression 
    :   '(' primitiveType ')' unaryExpression
    |   '(' type ')' unaryExpressionNotPlusMinus
    ;


primary 
    :   parExpression            
    |   'this' ('.' IDENTIFIER)* identifierSuffix?
    |   IDENTIFIER ('.' IDENTIFIER)* identifierSuffix?
    |   'super' superSuffix
    |   literal
    |   creator
    |   primitiveType (BRACKETS)* '.' 'class'
    |   'void' '.' 'class'
    ;
    

superSuffix  
    :   arguments
    |   '.' typeArguments? IDENTIFIER arguments?
    ;


identifierSuffix 
    :   BRACKETS+ '.' 'class'
    |   ('[' expression ']' )+
    |   arguments
    |   '.' 'class'
    |   '.' nonWildcardTypeArguments IDENTIFIER arguments
    |   '.' 'this'
    |   '.' 'super' arguments
    |   innerCreator
    ;


selector  
    :   '.' IDENTIFIER arguments?
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
    :   'new' createdName BRACKETS+ arrayInitializer
    |   'new' createdName '[' expression ']' (   '[' expression ']')* BRACKETS*
    ;

variableInitializer 
    :   arrayInitializer
    |   expression
    ;

arrayInitializer 
    :   '{' (variableInitializer (',' variableInitializer )* )? (COMMA)? '}' 
    ;


createdName 
    :   classOrInterfaceType
    |   primitiveType
    ;

innerCreator  
    :   '.' 'new' nonWildcardTypeArguments? IDENTIFIER typeArguments?  classCreatorRest
    ;


classCreatorRest 
    :   arguments classBody?
    ;


nonWildcardTypeArguments 
    :   '<' typeList '>'
    ;

arguments 
    :   '(' expressionList? ')'
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

