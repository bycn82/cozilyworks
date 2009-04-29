grammar Cozily;

options {
    backtrack = true; 
    memoize = true;
    output = AST;
    ASTLabelType = CommonTree;
}
@lexer::header{
package com.cozilyworks.cozily.parser;
}
@parser::header{
package com.cozilyworks.cozily.parser;
}
/********************************************************************************************
                          Parser section
*********************************************************************************************/
           
compilationUnit 
    :   (   (annotations
            )?
            packageDeclaration
        )?
        (importDeclaration
        )*
        (typeDeclaration
        )*
    ;

packageDeclaration 
    :   'package' qualifiedName
        ';'
    ;

importDeclaration  
    :   'import' 
        ('static'
        )?
        IDENTIFIER '.' '*'
        ';'       
    |   'import' 
        ('static'
        )?
        IDENTIFIER
        ('.' IDENTIFIER
        )+
        ('.' '*'
        )?
        ';'
    ;

qualifiedImportName 
    :   IDENTIFIER
        ('.' IDENTIFIER
        )*
    ;

typeDeclaration 
    :   classOrInterfaceDeclaration
    |   ';'
    ;

classOrInterfaceDeclaration 
    :    classDeclaration
    |   interfaceDeclaration
    ;
    
  
modifiers  
    :
    (    annotation
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
    )*
    ;


variableModifiers 
    :   (   'final'
        |   annotation
        )*
    ;
    

classDeclaration 
    :   normalClassDeclaration
    |   enumDeclaration
    ;

normalClassDeclaration 
    :   modifiers  'class' IDENTIFIER
        (typeParameters
        )?
        ('extends' type
        )?
        ('implements' typeList
        )?            
        classBody
    ;


typeParameters 
    :   '<'
            typeParameter
            (',' typeParameter
            )*
        '>'
    ;

typeParameter 
    :   IDENTIFIER
        ('extends' typeBound
        )?
    ;


typeBound 
    :   type
        ('&' type
        )*
    ;


enumDeclaration 
    :   modifiers 
        ('enum'
        ) 
        IDENTIFIER
        ('implements' typeList
        )?
        enumBody
    ;
    

enumBody 
    :   '{'
        (enumConstants
        )? 
        ','? 
        (enumBodyDeclarations
        )? 
        '}'
    ;

enumConstants 
    :   enumConstant
        (',' enumConstant
        )*
    ;

/**
 * NOTE: here differs from the javac grammar, missing TypeArguments.
 * EnumeratorDeclaration = AnnotationsOpt [TypeArguments] IDENTIFIER [ Arguments ] [ "{" ClassBody "}" ]
 */
enumConstant 
    :   (annotations
        )?
        IDENTIFIER
        (arguments
        )?
        (classBody
        )?
        /* TODO: $GScope::name = names.empty. enum constant body is actually
        an anonymous class, where constructor isn't allowed, have to add this check*/
    ;

enumBodyDeclarations 
    :   ';' 
        (classBodyDeclaration
        )*
    ;

interfaceDeclaration 
    :   normalInterfaceDeclaration
    |   annotationTypeDeclaration
    ;
    
normalInterfaceDeclaration 
    :   modifiers 'interface' IDENTIFIER
        (typeParameters
        )?
        ('extends' typeList
        )?
        interfaceBody
    ;

typeList 
    :   type
        (',' type
        )*
    ;

classBody 
    :   '{' 
        (classBodyDeclaration
        )* 
        '}'
    ;

interfaceBody 
    :   '{' 
        (interfaceBodyDeclaration
        )* 
        '}'
    ;

classBodyDeclaration 
    :   ';'
    |   ('static'
        )? 
        block
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
        /* For constructor, return type is null, name is 'init' */
         modifiers
        (typeParameters
        )?
        IDENTIFIER
        formalParameters
        ('throws' qualifiedNameList
        )?
        '{' 
        (explicitConstructorInvocation
        )?
        (blockStatement
        )*
        '}'
    |   modifiers
        (typeParameters
        )?
        (type
        |   'void'
        )
        IDENTIFIER
        formalParameters
        ('[' ']'
        )*
        ('throws' qualifiedNameList
        )?            
        (        
            block
        |   ';' 
        )
    ;


fieldDeclaration 
    :   modifiers
        type
        variableDeclarator
        (',' variableDeclarator
        )*
        ';'
    ;

variableDeclarator 
    :   IDENTIFIER
        ('[' ']'
        )*
        ('=' variableInitializer
        )?
    ;

/**
 *TODO: add predicates
 */
interfaceBodyDeclaration 
    :
        interfaceFieldDeclaration
    |   interfaceMethodDeclaration
    |   interfaceDeclaration
    |   classDeclaration
    |   ';'
    ;

interfaceMethodDeclaration 
    :   modifiers
        (typeParameters
        )?
        (type
        |'void'
        )
        IDENTIFIER
        formalParameters
        ('[' ']'
        )*
        ('throws' qualifiedNameList
        )? ';'
    ;

/**
 * NOTE, should not use variableDeclarator here, as it doesn't necessary require
 * an initializer, while an interface field does, or judge by the returned value.
 * But this gives better diagnostic message, or antlr won't predict this rule.
 */
interfaceFieldDeclaration 
    :   modifiers type variableDeclarator
        (',' variableDeclarator
        )*
        ';'
    ;


type 
    :   classOrInterfaceType
        ('[' ']'
        )*
    |   primitiveType
        ('[' ']'
        )*
    ;


classOrInterfaceType 
    :   IDENTIFIER
        (typeArguments
        )?
        ('.' IDENTIFIER
            (typeArguments
            )?
        )*
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
    :   '<' typeArgument
        (',' typeArgument
        )* 
        '>'
    ;

typeArgument 
    :   type
    |   '?'
        (
            ('extends'
            |'super'
            )
            type
        )?
    ;

qualifiedNameList 
    :   qualifiedName
        (',' qualifiedName
        )*
    ;

formalParameters 
    :   '('
        (formalParameterDecls
        )? 
        ')'
    ;

formalParameterDecls 
    :   ellipsisParameterDecl
    |   normalParameterDecl
        (',' normalParameterDecl
        )*
    |   (normalParameterDecl
        ','
        )+ 
        ellipsisParameterDecl
    ;

normalParameterDecl 
    :   variableModifiers type IDENTIFIER
        ('[' ']'
        )*
    ;

ellipsisParameterDecl 
    :   variableModifiers
        type  '...'
        IDENTIFIER
    ;


explicitConstructorInvocation 
    :   (nonWildcardTypeArguments
        )?     //NOTE: the position of Identifier 'super' is set to the type args position here
        ('this'
        |'super'
        )
        arguments ';'

    |   primary
        '.'
        (nonWildcardTypeArguments
        )?
        'super'
        arguments ';'
    ;

qualifiedName 
    :   IDENTIFIER
        ('.' IDENTIFIER
        )*
    ;

annotations 
    :   (annotation
        )+
    ;

/**
 *  Using an annotation. 
 * '@' is flaged in modifier
 */
annotation 
    :   '@' qualifiedName
        (   '('   
                  (   elementValuePairs
                  |   elementValue
                  )? 
            ')' 
        )?
    ;

elementValuePairs 
    :   elementValuePair
        (',' elementValuePair
        )*
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
    :   '{'
        (elementValue
            (',' elementValue
            )*
        )? (',')? '}'
    ;


/**
 * Annotation declaration.
 */
annotationTypeDeclaration 
    :   modifiers '@'
        'interface'
        IDENTIFIER
        annotationTypeBody
    ;


annotationTypeBody 
    :   '{' 
        (annotationTypeElementDeclaration
        )* 
        '}'
    ;

/**
 * NOTE: here use interfaceFieldDeclaration for field declared inside annotation. they are sytactically the same.
 */
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
    :   modifiers type IDENTIFIER
        '(' ')' ('default' elementValue
                )?
        ';'
        ;

block 
    :   '{'
        (blockStatement
        )*
        '}'
    ;

/*
staticBlock returns [JCBlock tree]
        @init {
            ListBuffer<JCStatement> stats = new ListBuffer<JCStatement>();
            int pos = ((AntlrJavacToken) $start).getStartIndex();
        }
        @after {
            $tree = T.at(pos).Block(Flags.STATIC, stats.toList());
            pu.storeEnd($tree, $stop);
            // construct a dummy static modifiers for end position
            pu.storeEnd(T.at(pos).Modifiers(Flags.STATIC,  com.sun.tools.javac.util.List.<JCAnnotation>nil()),$st);
        }
    :   st_1='static' '{' 
        (blockStatement
            {
                if ($blockStatement.tree == null) {
                    stats.appendList($blockStatement.list);
                } else {
                    stats.append($blockStatement.tree);
                }
            }
        )* '}'
    ;
*/
blockStatement 
    :   localVariableDeclarationStatement
    |   classOrInterfaceDeclaration
    |   statement
    ;


localVariableDeclarationStatement 
    :   localVariableDeclaration
        ';'
    ;

localVariableDeclaration 
    :   variableModifiers type
        variableDeclarator
        (',' variableDeclarator
        )*
    ;

statement 
    :   block
            
    |   ('assert'
        )
        expression (':' expression)? ';'
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
    |   'break'
            (IDENTIFIER
            )? ';'
    |   'continue'
            (IDENTIFIER
            )? ';'
    |   expression  ';'     
    |   IDENTIFIER ':' statement
    |   ';'

    ;

switchBlockStatementGroups 
    :   (switchBlockStatementGroup )*
    ;

switchBlockStatementGroup 
    :
        switchLabel
        (blockStatement
        )*
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
    :   catchClause
        (catchClause
        )*
    ;

catchClause 
    :   'catch' '(' formalParameter
        ')' block 
    ;

formalParameter 
    :   variableModifiers type IDENTIFIER
        ('[' ']'
        )*
    ;

forstatement 
    :   
        // enhanced for loop
        'for' '(' variableModifiers type IDENTIFIER ':' 
        expression ')' statement
            
        // normal for loop
    |   'for' '(' 
                (forInit
                )? ';' 
                (expression
                )? ';' 
                (expressionList
                )? ')' statement
    ;

forInit 
    :   localVariableDeclaration
    |   expressionList
    ;

parExpression 
    :   '(' expression ')'
    ;

expressionList 
    :   expression
        (',' expression
        )*
    ;


expression 
    :   conditionalExpression
        (assignmentOperator expression
        )?
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
    :   conditionalOrExpression
        ('?' expression ':' conditionalExpression
        )?
    ;

conditionalOrExpression 
    :   conditionalAndExpression
        ('||' conditionalAndExpression
        )*
    ;

conditionalAndExpression 
    :   inclusiveOrExpression
        ('&&' inclusiveOrExpression
        )*
    ;

inclusiveOrExpression 
    :   exclusiveOrExpression
        ('|' exclusiveOrExpression
        )*
    ;

exclusiveOrExpression 
    :   andExpression
        ('^' andExpression
        )*
    ;

andExpression 
    :   equalityExpression
        ('&' equalityExpression
        )*
    ;

equalityExpression 
    :   instanceOfExpression
        (   
            (   '=='
            |   '!='
            )
            instanceOfExpression
        )*
    ;

instanceOfExpression 
    :   relationalExpression
        ('instanceof' type
        )?
    ;

relationalExpression 
    :   shiftExpression
        (relationalOp shiftExpression
        )*
    ;

relationalOp 
    :    '<' '='
    |    '>' '='
    |   '<'
    |   '>'
    ;

shiftExpression 
    :   additiveExpression
        (shiftOp additiveExpression
        )*
    ;


shiftOp 
    :    '<' '<'
    |    '>' '>' '>'
    |    '>' '>'
    ;


additiveExpression 
    :   multiplicativeExpression
        (   
            (   '+'
            |   '-'
            )
            multiplicativeExpression
         )*
    ;

multiplicativeExpression 
    :
        unaryExpression
        (   
            (   '*'
            |   '/'
            |   '%'
            )
            unaryExpression
        )*
    ;

/**
 * NOTE: for '+' and '-', if the next token is int or long interal, then it's not a unary expression.
 *       it's a literal with signed value. INTLTERAL AND LONG LITERAL are added here for this.
 */
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
    |   primary
        (selector
        )*
        (   '++'
        |   '--'
        )?
    ;

castExpression 
    :   '(' primitiveType ')' unaryExpression
    |   '(' type ')' unaryExpressionNotPlusMinus
    ;

/**
 * have to use scope here, parameter passing isn't well supported in antlr.
 */
primary 
    :   parExpression            
    |   'this'
        ('.' IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   IDENTIFIER
        ('.' IDENTIFIER
        )*
        (identifierSuffix
        )?
    |   'super'
        superSuffix
    |   literal
    |   creator
    |   primitiveType
        ('[' ']'
        )*
        '.' 'class'
    |   'void' '.' 'class'
    ;
    

superSuffix  
    :   arguments
    |   '.' (typeArguments
        )?
        IDENTIFIER
        (arguments
        )?
    ;


identifierSuffix 
    :   ('[' ']'
        )+
        '.' 'class'
    |   ('[' expression ']'
        )+
    |   arguments
    |   '.' 'class'
    |   '.' nonWildcardTypeArguments IDENTIFIER arguments
    |   '.' 'this'
    |   '.' 'super' arguments
    |   innerCreator
    ;


selector  
    :   '.' IDENTIFIER
        (arguments
        )?
    |   '.' 'this'
    |   '.' 'super'
        superSuffix
    |   innerCreator
    |   '[' expression ']'
    ;

creator 
    :   'new' nonWildcardTypeArguments classOrInterfaceType classCreatorRest
    |   'new' classOrInterfaceType classCreatorRest
    |   arrayCreator
    ;

arrayCreator 
    :   'new' createdName
        '[' ']'
        ('[' ']'
        )*
        arrayInitializer

    |   'new' createdName
        '[' expression
        ']'
        (   '[' expression
            ']'
        )*
        ('[' ']'
        )*
    ;

variableInitializer 
    :   arrayInitializer
    |   expression
    ;

arrayInitializer 
    :   '{' 
            (variableInitializer
                (',' variableInitializer
                )*
            )? 
            (',')? 
        '}'             //Yang's fix, position change.
    ;


createdName 
    :   classOrInterfaceType
    |   primitiveType
    ;

innerCreator  
    :   '.' 'new'
        (nonWildcardTypeArguments
        )?
        IDENTIFIER
        (typeArguments
        )?
        classCreatorRest
    ;


classCreatorRest 
    :   arguments
        (classBody
        )?
    ;


nonWildcardTypeArguments 
    :   '<' typeList
        '>'
    ;

arguments 
    :   '(' (expressionList
        )? ')'
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

/**
 * These are headers help to make syntatical predicates, not necessary but helps to make grammar faster.
 */
 
classHeader 
    :   modifiers 'class' IDENTIFIER
    ;

enumHeader 
    :   modifiers ('enum'|IDENTIFIER) IDENTIFIER
    ;

interfaceHeader 
    :   modifiers 'interface' IDENTIFIER
    ;

annotationHeader 
    :   modifiers '@' 'interface' IDENTIFIER
    ;

typeHeader 
    :   modifiers ('class'|'enum'|('@' ? 'interface')) IDENTIFIER
    ;

methodHeader 
    :   modifiers typeParameters? (type|'void')? IDENTIFIER '('
    ;

fieldHeader 
    :   modifiers type IDENTIFIER ('['']')* ('='|','|';')
    ;

localVariableHeader 
    :   variableModifiers type IDENTIFIER ('['']')* ('='|','|';')
    ;




/********************************************************************************************
                  Lexer section
*********************************************************************************************/
// $<Lexer
LONGLITERAL
    :   IntegerNumber LongSuffix    ; 
INTLITERAL
    :   IntegerNumber     ;
    
fragment
IntegerNumber
    :   '0' |   '1'..'9' ('0'..'9')*   |   '0' ('0'..'7')+  |   HexPrefix HexDigit+   ;

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
        ) 
            {
                skip();
            }          
    ;
    
COMMENT
         @init{
            boolean isJavaDoc = false;
        }
    :   '/*'
            {
                if((char)input.LA(1) == '*'){
                    isJavaDoc = true;
                }
            }
        (options {greedy=false;} : . )* 
        '*/'
            {
                if(isJavaDoc==true){
                    $channel=HIDDEN;
                }else{
                    skip();
                }
            }
    ;

LINE_COMMENT
    :   '//' ~('\n'|'\r')*  ('\r\n' | '\r' | '\n') 
            {
                skip();
            }
    |   '//' ~('\n'|'\r')* 
            {
                skip();
            }
    ;   
// $<keywords    
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
// $>

// $<symbols
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
// $>     
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
// $>
