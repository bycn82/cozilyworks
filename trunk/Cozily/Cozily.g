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
->^(FILEDECLARATION0 	(annotations? packageDeclaration)? importDeclaration* typeDeclaration*)
	;
packageDeclaration 
    :   'package' qualifiedName ';'
->^(PACKAGEDECLARATION0     qualifiedName)
    ;
importDeclaration  
    :   'import' STATIC? qualifiedName DOTSTAR? ';'
->^(IMPORTDECLARATION0     STATIC? qualifiedName DOTSTAR?)
    ;
typeDeclaration 
    :   classOrInterfaceDeclaration
->^(TYPEDECLARATION0    classOrInterfaceDeclaration)
    ;
classOrInterfaceDeclaration 
    :   classDeclaration
->^(CLASSORINTERFACEDECLARATION0    classDeclaration)
    |   interfaceDeclaration
->^(CLASSORINTERFACEDECLARATION1    interfaceDeclaration)
    ;
modifiers  
    : 	modifier*
->^(MODIFIERS0  	modifier*)
    ;
modifier
    :	 annotation
->^(MODIFIER0 	 annotation)
    |   PUBLIC
->^(MODIFIER1    PUBLIC)
    |   PROTECTED
->^(MODIFIER2    PROTECTED)
    |   PRIVATE
->^(MODIFIER3    PRIVATE)
    |   STATIC
->^(MODIFIER4    STATIC)
    |   ABSTRACT
->^(MODIFIER5    ABSTRACT)
    |   FINAL
->^(MODIFIER6    FINAL)
    |   NATIVE
->^(MODIFIER7    NATIVE)
    |   SYNCHRONIZED
->^(MODIFIER8    SYNCHRONIZED)
    |   TRANSIENT
->^(MODIFIER9    TRANSIENT)
    |   VOLATILE
->^(MODIFIER10    VOLATILE)
    |   STRICTFP
->^(MODIFIER11    STRICTFP)
    ;
variableModifiers 
    :   variableModifier*
->^(VARIABLEMODIFIERS0    variableModifier*)
    ;
variableModifier
	:	annotation 
->^(VARIABLEMODIFIER0 	annotation)
	|	FINAL
->^(VARIABLEMODIFIER1 	FINAL)
	;
classDeclaration 
    :   normalClassDeclaration
->^(CLASSDECLARATION0    normalClassDeclaration)
    |   enumDeclaration
->^(CLASSDECLARATION1    enumDeclaration)
    ;
normalClassDeclaration 
    :   modifiers  'class' IDENTIFIER typeParameters? ('extends' type)? ('implements' typeList)? classBody
->^(NORMALCLASSDECLARATION0    modifiers   IDENTIFIER typeParameters? ( type)? ( typeList)? classBody)
    ;
typeParameters 
    :   '<' typeParameter (',' typeParameter)* '>'
->^(TYPEPARAMETERS0     typeParameter ( typeParameter)*)
    ;
typeParameter 
    :   IDENTIFIER ('extends' typeBound)?
->^(TYPEPARAMETER0    IDENTIFIER ( typeBound)?)
    ;
typeBound 
    :   type ('&' type)*
->^(TYPEBOUND0    type ( type)*)
    ;
enumDeclaration 
    :   modifiers 'enum' IDENTIFIER ('implements' typeList)? enumBody
->^(ENUMDECLARATION0    modifiers  IDENTIFIER ( typeList)? enumBody)
    ;
enumBody 
    :   '{' enumConstants? COMMA? (enumBodyDeclarations)? '}'
->^(ENUMBODY0     enumConstants? COMMA? (enumBodyDeclarations)?)
    ;
enumConstants 
    :   enumConstant (',' enumConstant)*
->^(ENUMCONSTANTS0    enumConstant ( enumConstant)*)
    ;
enumConstant 
    :   annotations? IDENTIFIER arguments? classBody?
->^(ENUMCONSTANT0    annotations? IDENTIFIER arguments? classBody?)
    ;
enumBodyDeclarations 
    :   ';' classBodyDeclaration*
->^(ENUMBODYDECLARATIONS0     classBodyDeclaration*)
    ;
interfaceDeclaration 
    :   normalInterfaceDeclaration
->^(INTERFACEDECLARATION0    normalInterfaceDeclaration)
    |   annotationTypeDeclaration
->^(INTERFACEDECLARATION1    annotationTypeDeclaration)
    ;
normalInterfaceDeclaration 
    :   modifiers 'interface' IDENTIFIER typeParameters?  ('extends' typeList)? interfaceBody
->^(NORMALINTERFACEDECLARATION0    modifiers  IDENTIFIER typeParameters?  ( typeList)? interfaceBody)
    ;
typeList 
    :   type (',' type)*
->^(TYPELIST0    type ( type)*)
    ;
classBody 
    :   '{' classBodyDeclaration* '}'
->^(CLASSBODY0     classBodyDeclaration*)
    ;
interfaceBody 
    :   '{' interfaceBodyDeclaration* '}'
->^(INTERFACEBODY0     interfaceBodyDeclaration*)
    ;
classBodyDeclaration 
    :   ';'
->^(CLASSBODYDECLARATION0 )
    |   STATIC? block
->^(CLASSBODYDECLARATION1    STATIC? block)
    |   memberDecl
->^(CLASSBODYDECLARATION2    memberDecl)
    ;
memberDecl 
    :    fieldDeclaration
->^(MEMBERDECL0     fieldDeclaration)
    |    methodDeclaration
->^(MEMBERDECL1     methodDeclaration)
    |    classDeclaration
->^(MEMBERDECL2     classDeclaration)
    |    interfaceDeclaration
->^(MEMBERDECL3     interfaceDeclaration)
    ;
methodDeclaration 
    :   modifiers typeParameters? IDENTIFIER formalParameters ('throws' qualifiedNameList)? '{' explicitConstructorInvocation? blockStatement* '}'
->^(METHODDECLARATION0    modifiers typeParameters? IDENTIFIER formalParameters ( qualifiedNameList)?  explicitConstructorInvocation? blockStatement*)
    |   modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? blockOrComma
->^(METHODDECLARATION1    modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ( qualifiedNameList)? blockOrComma)
    ;
blockOrComma
	:	block 
->^(BLOCKORCOMMA0 	block)
	|   SEMI  
->^(BLOCKORCOMMA1    SEMI)
	;
returnType
	:	type
->^(RETURNTYPE0 	type)
	|	VOID
->^(RETURNTYPE1 	VOID)
	;
fieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
->^(FIELDDECLARATION0    modifiers type variableDeclarator ( variableDeclarator)*)
    ;
variableDeclarator 
    :   IDENTIFIER BRACKETS* ('=' variableInitializer)?
->^(VARIABLEDECLARATOR0    IDENTIFIER BRACKETS* ( variableInitializer)?)
    ;
interfaceBodyDeclaration 
    :   interfaceFieldDeclaration
->^(INTERFACEBODYDECLARATION0    interfaceFieldDeclaration)
    |   interfaceMethodDeclaration
->^(INTERFACEBODYDECLARATION1    interfaceMethodDeclaration)
    |   interfaceDeclaration
->^(INTERFACEBODYDECLARATION2    interfaceDeclaration)
    |   classDeclaration
->^(INTERFACEBODYDECLARATION3    classDeclaration)
    |   SEMI
->^(INTERFACEBODYDECLARATION4    SEMI)
    ;
interfaceMethodDeclaration 
    :   modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ('throws' qualifiedNameList)? ';'
->^(INTERFACEMETHODDECLARATION0    modifiers typeParameters? returnType IDENTIFIER formalParameters BRACKETS* ( qualifiedNameList)?)
    ;
interfaceFieldDeclaration 
    :   modifiers type variableDeclarator (',' variableDeclarator)* ';'
->^(INTERFACEFIELDDECLARATION0    modifiers type variableDeclarator ( variableDeclarator)*)
    ;
type 
    :   classOrInterfaceType BRACKETS*
->^(TYPE0    classOrInterfaceType BRACKETS*)
    |   primitiveType BRACKETS*
->^(TYPE1    primitiveType BRACKETS*)
    ;
classOrInterfaceType 
    :   IDENTIFIER typeArguments? ('.' IDENTIFIER typeArguments? )*
->^(CLASSORINTERFACETYPE0    IDENTIFIER typeArguments? ( IDENTIFIER typeArguments? )*)
    ;
primitiveType  
    :   BOOLEAN
->^(PRIMITIVETYPE0    BOOLEAN)
    |   CHAR
->^(PRIMITIVETYPE1    CHAR)
    |   BYTE
->^(PRIMITIVETYPE2    BYTE)
    |   SHORT
->^(PRIMITIVETYPE3    SHORT)
    |   INT
->^(PRIMITIVETYPE4    INT)
    |   LONG
->^(PRIMITIVETYPE5    LONG)
    |   FLOAT
->^(PRIMITIVETYPE6    FLOAT)
    |   DOUBLE
->^(PRIMITIVETYPE7    DOUBLE)
    ;
typeArguments 
    :   '<' typeArgument (',' typeArgument)* '>'
->^(TYPEARGUMENTS0     typeArgument ( typeArgument)*)
    ;
typeArgument 
    :   type
->^(TYPEARGUMENT0    type)
    |   '?' ( extendsOrSuper type )?
->^(TYPEARGUMENT1     ( extendsOrSuper type )?)
    ;
extendsOrSuper
	:	EXTENDS
->^(EXTENDSORSUPER0 	EXTENDS)
	|	SUPER
->^(EXTENDSORSUPER1 	SUPER)
	;
qualifiedNameList 
    :    (',' qualifiedName)*
->^(QUALIFIEDNAMELIST0     ( qualifiedName)*)
    ;
formalParameters 
    :   '('formalParameterDecls? ')'
->^(FORMALPARAMETERS0    formalParameterDecls?)
    ;
formalParameterDecls 
    :   ellipsisParameterDecl
->^(FORMALPARAMETERDECLS0    ellipsisParameterDecl)
    |   normalParameterDecl (',' normalParameterDecl)*
->^(FORMALPARAMETERDECLS1    normalParameterDecl ( normalParameterDecl)*)
    |   (normalParameterDecl ',')+ ellipsisParameterDecl
->^(FORMALPARAMETERDECLS2    (normalParameterDecl )+ ellipsisParameterDecl)
    ;
normalParameterDecl 
    :   variableModifiers type IDENTIFIER BRACKETS*
->^(NORMALPARAMETERDECL0    variableModifiers type IDENTIFIER BRACKETS*)
    ;
ellipsisParameterDecl 
    :   variableModifiers type  '...' IDENTIFIER
->^(ELLIPSISPARAMETERDECL0    variableModifiers type   IDENTIFIER)
    ;
explicitConstructorInvocation 
    :   nonWildcardTypeArguments? thisOrSuper arguments ';' 
->^(EXPLICITCONSTRUCTORINVOCATION0    nonWildcardTypeArguments? thisOrSuper arguments)
    |   primary '.' nonWildcardTypeArguments? 'super' arguments ';'
->^(EXPLICITCONSTRUCTORINVOCATION1    primary  nonWildcardTypeArguments?  arguments)
    ;
thisOrSuper
	:	THIS
->^(THISORSUPER0 	THIS)
	|	SUPER
->^(THISORSUPER1 	SUPER)
	;
qualifiedName 
    :   IDENTIFIER ('.' IDENTIFIER)*
->^(QUALIFIEDNAME0    IDENTIFIER ( IDENTIFIER)*)
    ;
annotations 
    :   annotation+
->^(ANNOTATIONS0    annotation+)
    ;
annotation 
    :   '@' qualifiedName (   '(' elementOfAnno?  ')' )?
->^(ANNOTATION0     qualifiedName (    elementOfAnno?   )?)
    ;
elementOfAnno
	:	elementValuePairs 
->^(ELEMENTOFANNO0 	elementValuePairs)
	|	elementValue
->^(ELEMENTOFANNO1 	elementValue)
	;
elementValuePairs 
    :   elementValuePair (',' elementValuePair)*
->^(ELEMENTVALUEPAIRS0    elementValuePair ( elementValuePair)*)
    ;
elementValuePair 
    :   IDENTIFIER '=' elementValue
->^(ELEMENTVALUEPAIR0    IDENTIFIER  elementValue)
    ;
elementValue 
    :   conditionalExpression
->^(ELEMENTVALUE0    conditionalExpression)
    |   annotation
->^(ELEMENTVALUE1    annotation)
    |   elementValueArrayInitializer
->^(ELEMENTVALUE2    elementValueArrayInitializer)
    ;
elementValueArrayInitializer 
    :   '{'(elementValue  (',' elementValue)*  )? COMMA? '}'
->^(ELEMENTVALUEARRAYINITIALIZER0    (elementValue  ( elementValue)*  )? COMMA?)
    ;
annotationTypeDeclaration 
    :   modifiers '@' 'interface' IDENTIFIER annotationTypeBody
->^(ANNOTATIONTYPEDECLARATION0    modifiers   IDENTIFIER annotationTypeBody)
    ;
annotationTypeBody 
    :   '{' annotationTypeElementDeclaration* '}'
->^(ANNOTATIONTYPEBODY0     annotationTypeElementDeclaration*)
    ;
annotationTypeElementDeclaration 
    :   annotationMethodDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION0    annotationMethodDeclaration)
    |   interfaceFieldDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION1    interfaceFieldDeclaration)
    |   normalClassDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION2    normalClassDeclaration)
    |   normalInterfaceDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION3    normalInterfaceDeclaration)
    |   enumDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION4    enumDeclaration)
    |   annotationTypeDeclaration
->^(ANNOTATIONTYPEELEMENTDECLARATION5    annotationTypeDeclaration)
    |   ';'
->^(ANNOTATIONTYPEELEMENTDECLARATION6 )
    ;
annotationMethodDeclaration 
    :   modifiers type IDENTIFIER '(' ')' ('default' elementValue)? ';'
->^(ANNOTATIONMETHODDECLARATION0    modifiers type IDENTIFIER   ( elementValue)?)
    ;
block 
    :   '{' blockStatement* '}'
->^(BLOCK0     blockStatement*)
    ;
blockStatement 
    :   localVariableDeclarationStatement
->^(BLOCKSTATEMENT0    localVariableDeclarationStatement)
    |   classOrInterfaceDeclaration
->^(BLOCKSTATEMENT1    classOrInterfaceDeclaration)
    |   statement
->^(BLOCKSTATEMENT2    statement)
    ;
localVariableDeclarationStatement 
    :   localVariableDeclaration ';'
->^(LOCALVARIABLEDECLARATIONSTATEMENT0    localVariableDeclaration)
    ;
localVariableDeclaration 
    :   variableModifiers type variableDeclarator (',' variableDeclarator)*
->^(LOCALVARIABLEDECLARATION0    variableModifiers type variableDeclarator ( variableDeclarator)*)
    ;
statement 
    :   block
->^(STATEMENT0    block)
    |   'assert'  expression (':' expression)? ';'    
->^(STATEMENT1      expression ( expression)?)
    |   'if' parExpression statement ('else' statement)?      
->^(STATEMENT2     parExpression statement ( statement)?)
    |   forstatement
->^(STATEMENT3    forstatement)
    |   'while' parExpression statement
->^(STATEMENT4     parExpression statement)
    |   'do' statement 'while' parExpression ';'
->^(STATEMENT5     statement  parExpression)
    |   trystatement
->^(STATEMENT6    trystatement)
    |   'switch' parExpression '{' switchBlockStatementGroups '}'
->^(STATEMENT7     parExpression  switchBlockStatementGroups)
    |   'synchronized' parExpression block
->^(STATEMENT8     parExpression block)
    |   'return' expression? ';'
->^(STATEMENT9     expression?)
    |   'throw' expression ';'
->^(STATEMENT10     expression)
    |   'break' IDENTIFIER? ';'
->^(STATEMENT11     IDENTIFIER?)
    |   'continue'IDENTIFIER? ';'
->^(STATEMENT12    IDENTIFIER?)
    |   expression  ';'     
->^(STATEMENT13    expression)
    |   IDENTIFIER ':' statement
->^(STATEMENT14    IDENTIFIER  statement)
    |   SEMI
->^(STATEMENT15    SEMI)
    ;
switchBlockStatementGroups 
    :   switchBlockStatementGroup*
->^(SWITCHBLOCKSTATEMENTGROUPS0    switchBlockStatementGroup*)
    ;
switchBlockStatementGroup 
    :   switchLabel blockStatement*
->^(SWITCHBLOCKSTATEMENTGROUP0    switchLabel blockStatement*)
    ;
switchLabel 
    :   CASE expression ':'
->^(SWITCHLABEL0    CASE expression)
    |   DEFAULT ':'
->^(SWITCHLABEL1    DEFAULT)
    ;
trystatement 
    :   'try' block   catches 'finally' block
->^(TRYSTATEMENT0     block   catches  block)
	| 'try' block  catches
->^(TRYSTATEMENT1   block  catches)
    | 'try' block  'finally' block    
->^(TRYSTATEMENT2   block   block)
    ;
catches 
    :   catchClause+
->^(CATCHES0    catchClause+)
    ;
catchClause 
    :   'catch' '(' formalParameter ')' block 
->^(CATCHCLAUSE0      formalParameter  block)
    ;
formalParameter 
    :   variableModifiers type IDENTIFIER BRACKETS*
->^(FORMALPARAMETER0    variableModifiers type IDENTIFIER BRACKETS*)
    ;
forstatement 
    :   'for' '(' variableModifiers type IDENTIFIER ':' expression ')' statement
->^(FORSTATEMENT0      variableModifiers type IDENTIFIER  expression  statement)
    |   'for' '(' forInit? ';' expression? ';' expressionList? ')' statement
->^(FORSTATEMENT1      forInit?  expression?  expressionList?  statement)
    ;
forInit 
    :   localVariableDeclaration
->^(FORINIT0    localVariableDeclaration)
    |   expressionList
->^(FORINIT1    expressionList)
    ;
parExpression 
    :   '(' expression ')'
->^(PAREXPRESSION0     expression)
    ;
expressionList 
    :   expression (',' expression)*
->^(EXPRESSIONLIST0    expression ( expression)*)
    ;
expression 
    :   conditionalExpression (assignmentOperator expression)?
->^(EXPRESSION0    conditionalExpression (assignmentOperator expression)?)
    ;
assignmentOperator 
    :   EQ
->^(ASSIGNMENTOPERATOR0    EQ)
    |   PLUSEQ
->^(ASSIGNMENTOPERATOR1    PLUSEQ)
    |   SUBEQ
->^(ASSIGNMENTOPERATOR2    SUBEQ)
    |   STAREQ
->^(ASSIGNMENTOPERATOR3    STAREQ)
    |   SLASHEQ
->^(ASSIGNMENTOPERATOR4    SLASHEQ)
    |   AMPEQ
->^(ASSIGNMENTOPERATOR5    AMPEQ)
    |   BAREQ
->^(ASSIGNMENTOPERATOR6    BAREQ)
    |   CARETEQ
->^(ASSIGNMENTOPERATOR7    CARETEQ)
    |   PERCENTEQ
->^(ASSIGNMENTOPERATOR8    PERCENTEQ)
    |   LT LT EQ
->^(ASSIGNMENTOPERATOR9    LT LT EQ)
    |   GT GT GT EQ
->^(ASSIGNMENTOPERATOR10    GT GT GT EQ)
    |   GT GT EQ
->^(ASSIGNMENTOPERATOR11    GT GT EQ)
    ;
conditionalExpression 
    :   conditionalOrExpression ('?' expression ':' conditionalExpression)?
->^(CONDITIONALEXPRESSION0    conditionalOrExpression ( expression  conditionalExpression)?)
    ;
conditionalOrExpression 
    :   conditionalAndExpression ('||' conditionalAndExpression)*
->^(CONDITIONALOREXPRESSION0    conditionalAndExpression ( conditionalAndExpression)*)
    ;
conditionalAndExpression 
    :   inclusiveOrExpression ('&&' inclusiveOrExpression)*
->^(CONDITIONALANDEXPRESSION0    inclusiveOrExpression ( inclusiveOrExpression)*)
    ;
inclusiveOrExpression 
    :   exclusiveOrExpression ('|' exclusiveOrExpression)*
->^(INCLUSIVEOREXPRESSION0    exclusiveOrExpression ( exclusiveOrExpression)*)
    ;
exclusiveOrExpression 
    :   andExpression ('^' andExpression)*
->^(EXCLUSIVEOREXPRESSION0    andExpression ( andExpression)*)
    ;
andExpression 
    :   equalityExpression ('&' equalityExpression)*
->^(ANDEXPRESSION0    equalityExpression ( equalityExpression)*)
    ;
equalityExpression 
    :   instanceOfExpression ( equalOrNotequal instanceOfExpression)*
->^(EQUALITYEXPRESSION0    instanceOfExpression ( equalOrNotequal instanceOfExpression)*)
    ;
equalOrNotequal
	:	EQEQ
->^(EQUALORNOTEQUAL0 	EQEQ)
	|	BANGEQ
->^(EQUALORNOTEQUAL1 	BANGEQ)
	;
instanceOfExpression 
    :   relationalExpression ('instanceof' type )?
->^(INSTANCEOFEXPRESSION0    relationalExpression ( type )?)
    ;
relationalExpression 
    :   shiftExpression (relationalOp shiftExpression)*
->^(RELATIONALEXPRESSION0    shiftExpression (relationalOp shiftExpression)*)
    ;
relationalOp 
    :   LT EQ
->^(RELATIONALOP0    LT EQ)
    |   GT EQ
->^(RELATIONALOP1    GT EQ)
    |   LT
->^(RELATIONALOP2    LT)
    |   GT
->^(RELATIONALOP3    GT)
    ;
shiftExpression 
    :   additiveExpression (shiftOp additiveExpression)*
->^(SHIFTEXPRESSION0    additiveExpression (shiftOp additiveExpression)*)
    ;
shiftOp 
    :    LT LT
->^(SHIFTOP0     LT LT)
    |    GT GT
->^(SHIFTOP1     GT GT)
    |    GT GT GT
->^(SHIFTOP2     GT GT GT)
    ;
additiveExpression 
    :   multiplicativeExpression ( plusOrMinus multiplicativeExpression)*
->^(ADDITIVEEXPRESSION0    multiplicativeExpression ( plusOrMinus multiplicativeExpression)*)
    ;
plusOrMinus
	:	PLUS
->^(PLUSORMINUS0 	PLUS)
	|	SUB
->^(PLUSORMINUS1 	SUB)
	;
multiplicativeExpression 
    :	unaryExpression ( timesDivide unaryExpression)*
->^(MULTIPLICATIVEEXPRESSION0 	unaryExpression ( timesDivide unaryExpression)*)
    ;
timesDivide
	:	STAR
->^(TIMESDIVIDE0 	STAR)
	|	SLASH
->^(TIMESDIVIDE1 	SLASH)
	|	PERCENT
->^(TIMESDIVIDE2 	PERCENT)
	;
unaryExpression 
    :   '+'  unaryExpression
->^(UNARYEXPRESSION0      unaryExpression)
    |   '-' unaryExpression
->^(UNARYEXPRESSION1     unaryExpression)
    |   '++' unaryExpression
->^(UNARYEXPRESSION2     unaryExpression)
    |   '--' unaryExpression
->^(UNARYEXPRESSION3     unaryExpression)
    |   unaryExpressionNotPlusMinus
->^(UNARYEXPRESSION4    unaryExpressionNotPlusMinus)
    ;
unaryExpressionNotPlusMinus 
    :   '~' unaryExpression
->^(UNARYEXPRESSIONNOTPLUSMINUS0     unaryExpression)
    |   '!' unaryExpression
->^(UNARYEXPRESSIONNOTPLUSMINUS1     unaryExpression)
    |   castExpression
->^(UNARYEXPRESSIONNOTPLUSMINUS2    castExpression)
    |   primary selector* doublePlusMinus?
->^(UNARYEXPRESSIONNOTPLUSMINUS3    primary selector* doublePlusMinus?)
    ;
doublePlusMinus
	:	PLUSPLUS
->^(DOUBLEPLUSMINUS0 	PLUSPLUS)
	|	SUBSUB
->^(DOUBLEPLUSMINUS1 	SUBSUB)
	;
castExpression 
    :   '(' primitiveType ')' unaryExpression
->^(CASTEXPRESSION0     primitiveType  unaryExpression)
    |   '(' type ')' unaryExpressionNotPlusMinus
->^(CASTEXPRESSION1     type  unaryExpressionNotPlusMinus)
    ;
primary 
    :   parExpression            
->^(PRIMARY0    parExpression)
    |   'this' ('.' IDENTIFIER)* identifierSuffix?
->^(PRIMARY1     ( IDENTIFIER)* identifierSuffix?)
    |   IDENTIFIER ('.' IDENTIFIER)* identifierSuffix?
->^(PRIMARY2    IDENTIFIER ( IDENTIFIER)* identifierSuffix?)
    |   'super' superSuffix
->^(PRIMARY3     superSuffix)
    |   literal
->^(PRIMARY4    literal)
    |   creator
->^(PRIMARY5    creator)
    |   primitiveType (BRACKETS)* '.' 'class'
->^(PRIMARY6    primitiveType (BRACKETS)*)
    |   'void' '.' 'class'
->^(PRIMARY7 )
    ;
superSuffix  
    :   arguments
->^(SUPERSUFFIX0    arguments)
    |   '.' typeArguments? IDENTIFIER arguments?
->^(SUPERSUFFIX1     typeArguments? IDENTIFIER arguments?)
    ;
identifierSuffix 
    :   BRACKETS+ '.' 'class'
->^(IDENTIFIERSUFFIX0    BRACKETS+)
    |   ('[' expression ']' )+
->^(IDENTIFIERSUFFIX1    ( expression  )+)
    |   arguments
->^(IDENTIFIERSUFFIX2    arguments)
    |   '.' 'class'
->^(IDENTIFIERSUFFIX3 )
    |   '.' nonWildcardTypeArguments IDENTIFIER arguments
->^(IDENTIFIERSUFFIX4     nonWildcardTypeArguments IDENTIFIER arguments)
    |   '.' 'this'
->^(IDENTIFIERSUFFIX5 )
    |   '.' 'super' arguments
->^(IDENTIFIERSUFFIX6      arguments)
    |   innerCreator
->^(IDENTIFIERSUFFIX7    innerCreator)
    ;
selector  
    :   '.' IDENTIFIER arguments?
->^(SELECTOR0     IDENTIFIER arguments?)
    |   '.' 'this'
->^(SELECTOR1 )
    |   '.' 'super' superSuffix
->^(SELECTOR2      superSuffix)
    |   innerCreator
->^(SELECTOR3    innerCreator)
    |   '[' expression ']'
->^(SELECTOR4     expression)
    ;
creator 
    :   'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
->^(CREATOR0     nonWildcardTypeArguments classOrInterfaceType classCreatorRest)
    |   'new' classOrInterfaceType classCreatorRest
->^(CREATOR1     classOrInterfaceType classCreatorRest)
    |   arrayCreator
->^(CREATOR2    arrayCreator)
    ;
arrayCreator 
    :   'new' createdName BRACKETS+ arrayInitializer
->^(ARRAYCREATOR0     createdName BRACKETS+ arrayInitializer)
    |   'new' createdName '[' expression ']' (   '[' expression ']')* BRACKETS*
->^(ARRAYCREATOR1     createdName  expression  (    expression )* BRACKETS*)
    ;
variableInitializer 
    :   arrayInitializer
->^(VARIABLEINITIALIZER0    arrayInitializer)
    |   expression
->^(VARIABLEINITIALIZER1    expression)
    ;
arrayInitializer 
    :   '{' (variableInitializer (',' variableInitializer )* )? (COMMA)? '}' 
->^(ARRAYINITIALIZER0     (variableInitializer ( variableInitializer )* )? (COMMA)?)
    ;
createdName 
    :   classOrInterfaceType
->^(CREATEDNAME0    classOrInterfaceType)
    |   primitiveType
->^(CREATEDNAME1    primitiveType)
    ;
innerCreator  
    :   '.' 'new' nonWildcardTypeArguments? IDENTIFIER typeArguments?  classCreatorRest
->^(INNERCREATOR0      nonWildcardTypeArguments? IDENTIFIER typeArguments?  classCreatorRest)
    ;
classCreatorRest 
    :   arguments classBody?
->^(CLASSCREATORREST0    arguments classBody?)
    ;
nonWildcardTypeArguments 
    :   '<' typeList '>'
->^(NONWILDCARDTYPEARGUMENTS0     typeList)
    ;
arguments 
    :   '(' expressionList? ')'
->^(ARGUMENTS0     expressionList?)
    ;
literal 
    :   INTLITERAL
->^(LITERAL0    INTLITERAL)
    |   LONGLITERAL
->^(LITERAL1    LONGLITERAL)
    |   FLOATLITERAL
->^(LITERAL2    FLOATLITERAL)
    |   DOUBLELITERAL
->^(LITERAL3    DOUBLELITERAL)
    |   CHARLITERAL
->^(LITERAL4    CHARLITERAL)
    |   STRINGLITERAL
->^(LITERAL5    STRINGLITERAL)
    |   TRUE
->^(LITERAL6    TRUE)
    |   FALSE
->^(LITERAL7    FALSE)
    |   NULL
->^(LITERAL8    NULL)
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

