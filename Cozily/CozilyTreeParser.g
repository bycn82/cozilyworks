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


@treeparser::members {
    
private boolean mMessageCollectionEnabled = false;
private List<String> mMessages;

/**
 * Switches error message collection on or of.
 * <p>
 * The standard destination for parser error messages is <code>
 * System.err</code>. However, if <code>true</code> gets passed to this method 
 * this default behaviour will be switched off and all error messages will be 
 * collected instead of writing them to an output stream.
 * <p>
 * The default value is <code>false</code>.
 *
 * @param pNewState  <code>true</code> if error messages should be collected.
 */
public void enableErrorMessageCollection(boolean pNewState) {

    mMessageCollectionEnabled = pNewState;
    if (mMessages == null && mMessageCollectionEnabled) {
        mMessages = new ArrayList<String>();
    }
}

/**
 * Collects an error message or passes the error message to <code>
 * super.emitErrorMessage(...)</code>.
 * <p>
 * The actual behaviour depends on whether collecting error messages has been 
 * enabled or not.
 *
 * @param pMessage  The error message.
 */
@Override
public void emitErrorMessage(String pMessage) {

    if (mMessageCollectionEnabled) {
        mMessages.add(pMessage);
    } else {
        super.emitErrorMessage(pMessage);
    }
}

/**
 * Returns collected error messages.
 * <p>
 * This method returns a copy of the internal list of error messages and clears
 * the internal list.
 * <p>
 * Note that calling this method eqauls to a <code>getMessages(null)</code>
 * call.
 *
 * @see #getMessages(List)
 *
 * @return  A list holding collected error messages or <code>null</code> if
 *          collecting error messages is disabled. Of course, the returned list 
 *		    may be empty if no error message has been emited.
 */
public List<String> getMessages() {

	return getMessages(null);
}

/**
 * Returns collected error messages.
 *
 * @param pUserList  If this argument is not <code>null</code> the error
 *                   messages will be added to this list and it's this list that
 *                   will be returned. Otherwise a copy of the internal list of 
 *                   error messages will be created and returned. The internal
 *                   list will be cleared just before the method returns.
 *
 * @return  A list holding collected error messages. If collecting error 
 *          messages is disabled <code>null</code> will be returned, even if the 
 *			argument <code>pUserList</code> is not <code>null</code>.
 */
public List<String> getMessages(List<String> pUserList) {

	if (!mMessageCollectionEnabled) {
	    return null;
	}
	List<String> result = pUserList;
	if (result == null) {
		result = new ArrayList<String>();
	}
	result.addAll(mMessages);
    mMessages.clear();
    
    return result;
}

/**
 * Tells if there is any collected error messages.
 *
 * @return  <code>true</code> if there is at least one collected error message.
 */
public boolean hasErrors() {

    return mMessages != null && mMessages.size() > 0;
}
} // @treeparser::members

// Starting point for parsing a Java file.
javaSource returns[JavaSource rtn]
@init{rtn=new JavaSource();}
:   ^(JAVA_SOURCE (x2=annotationList{rtn.setAnnotationList(x2);}) (x3=packageDeclaration{rtn.setPackageDeclaration(x3);})? (x4=importDeclaration{rtn.addImportDeclaration(x4);})* (x5=typeDeclaration{rtn.addTypeDeclaration(x5);})*)
;

packageDeclaration returns[PackageDeclaration rtn]
@init{rtn=new PackageDeclaration();}
:   ^((x6=PACKAGE{rtn.setPACKAGE($x6.text);}) (x7=qualifiedIdentifier{rtn.setQualifiedIdentifier(x7);}))
;

importDeclaration returns[ImportDeclaration rtn]
@init{rtn=new ImportDeclaration();}
:   ^((x8=IMPORT{rtn.setIMPORT($x8.text);}) (x9=STATIC{rtn.setSTATIC($x9.text);})? (x10=qualifiedIdentifier{rtn.setQualifiedIdentifier(x10);}) (x11=DOTSTAR{rtn.setDOTSTAR($x11.text);})?)
;

typeDeclaration returns[TypeDeclaration rtn]
@init{rtn=new TypeDeclaration();}
:   ^((x12=CLASS{rtn.setCLASS($x12.text);}) (x13=modifierList{rtn.setModifierList(x13);}) (x14=IDENT{rtn.setIDENT($x14.text);}) (x15=genericTypeParameterList{rtn.setGenericTypeParameterList(x15);})? (x16=extendsClause{rtn.setExtendsClause(x16);})? (x17=implementsClause{rtn.setImplementsClause(x17);})? (x18=classTopLevelScope{rtn.setClassTopLevelScope(x18);}))
|   ^((x19=INTERFACE{rtn.setINTERFACE($x19.text);}) (x20=modifierList{rtn.setModifierList(x20);}) (x21=IDENT{rtn.setIDENT($x21.text);}) (x22=genericTypeParameterList{rtn.setGenericTypeParameterList(x22);})? (x23=extendsClause{rtn.setExtendsClause(x23);})? (x24=interfaceTopLevelScope{rtn.setInterfaceTopLevelScope(x24);}))
|   ^((x25=ENUM{rtn.setENUM($x25.text);}) (x26=modifierList{rtn.setModifierList(x26);}) (x27=IDENT{rtn.setIDENT($x27.text);}) (x28=implementsClause{rtn.setImplementsClause(x28);})? (x29=enumTopLevelScope{rtn.setEnumTopLevelScope(x29);}))
|   ^((x30=AT{rtn.setAT($x30.text);}) (x31=modifierList{rtn.setModifierList(x31);}) (x32=IDENT{rtn.setIDENT($x32.text);}) (x33=annotationTopLevelScope{rtn.setAnnotationTopLevelScope(x33);}))
;

extendsClause returns[ExtendsClause rtn]
@init{rtn=new ExtendsClause();}
:   ^(EXTENDS_CLAUSE (x35=type{rtn.addType(x35);})+)
;

implementsClause returns[ImplementsClause rtn]
@init{rtn=new ImplementsClause();}
:   ^(IMPLEMENTS_CLAUSE (x37=type{rtn.addType(x37);})+)
;

genericTypeParameterList returns[GenericTypeParameterList rtn]
@init{rtn=new GenericTypeParameterList();}
:   ^(GENERIC_TYPE_PARAM_LIST (x39=genericTypeParameter{rtn.addGenericTypeParameter(x39);})+)
;

genericTypeParameter returns[GenericTypeParameter rtn]
@init{rtn=new GenericTypeParameter();}
:   ^((x40=IDENT{rtn.setIDENT($x40.text);}) (x41=bound{rtn.setBound(x41);})?)
;

bound returns[Bound rtn]
@init{rtn=new Bound();}
:   ^(EXTENDS_BOUND_LIST (x43=type{rtn.addType(x43);})+)
;

enumTopLevelScope returns[EnumTopLevelScope rtn]
@init{rtn=new EnumTopLevelScope();}
:   ^(ENUM_TOP_LEVEL_SCOPE (x45=enumConstant{rtn.addEnumConstant(x45);})* (x46=classTopLevelScope{rtn.setClassTopLevelScope(x46);})?)
;

enumConstant returns[EnumConstant rtn]
@init{rtn=new EnumConstant();}
:   ^((x47=IDENT{rtn.setIDENT($x47.text);}) (x48=annotationList{rtn.setAnnotationList(x48);}) (x49=arguments{rtn.setArguments(x49);})? (x50=classTopLevelScope{rtn.setClassTopLevelScope(x50);})?)
;

classTopLevelScope returns[ClassTopLevelScope rtn]
@init{rtn=new ClassTopLevelScope();}
:   ^(CLASS_TOP_LEVEL_SCOPE (x52=classScopeDeclarations{rtn.addClassScopeDeclarations(x52);})*)
;

classScopeDeclarations returns[ClassScopeDeclarations rtn]
@init{rtn=new ClassScopeDeclarations();}
:   ^(CLASS_INSTANCE_INITIALIZER (x54=block{rtn.setBlock(x54);}))
|   ^(CLASS_STATIC_INITIALIZER (x56=block{rtn.setBlock(x56);}))
|   ^(FUNCTION_METHOD_DECL (x58=modifierList{rtn.setModifierList(x58);}) (x59=genericTypeParameterList{rtn.setGenericTypeParameterList(x59);})? (x60=type{rtn.setType(x60);}) (x61=IDENT{rtn.setIDENT($x61.text);}) (x62=formalParameterList{rtn.setFormalParameterList(x62);}) (x63=arrayDeclaratorList{rtn.setArrayDeclaratorList(x63);})? (x64=throwsClause{rtn.setThrowsClause(x64);})? (x65=block{rtn.setBlock(x65);})?)
|   ^(VOID_METHOD_DECL (x67=modifierList{rtn.setModifierList(x67);}) (x68=genericTypeParameterList{rtn.setGenericTypeParameterList(x68);})? (x69=IDENT{rtn.setIDENT($x69.text);}) (x70=formalParameterList{rtn.setFormalParameterList(x70);}) (x71=throwsClause{rtn.setThrowsClause(x71);})? (x72=block{rtn.setBlock(x72);})?)
|   ^(VAR_DECLARATION (x74=modifierList{rtn.setModifierList(x74);}) (x75=type{rtn.setType(x75);}) (x76=variableDeclaratorList{rtn.setVariableDeclaratorList(x76);}))
|   ^(CONSTRUCTOR_DECL (x78=modifierList{rtn.setModifierList(x78);}) (x79=genericTypeParameterList{rtn.setGenericTypeParameterList(x79);})? (x80=formalParameterList{rtn.setFormalParameterList(x80);}) (x81=throwsClause{rtn.setThrowsClause(x81);})? (x82=block{rtn.setBlock(x82);}))
|   (x83=typeDeclaration{rtn.setTypeDeclaration(x83);})
;

interfaceTopLevelScope returns[InterfaceTopLevelScope rtn]
@init{rtn=new InterfaceTopLevelScope();}
:   ^(INTERFACE_TOP_LEVEL_SCOPE (x85=interfaceScopeDeclarations{rtn.addInterfaceScopeDeclarations(x85);})*)
;

interfaceScopeDeclarations returns[InterfaceScopeDeclarations rtn]
@init{rtn=new InterfaceScopeDeclarations();}
:   ^(FUNCTION_METHOD_DECL (x87=modifierList{rtn.setModifierList(x87);}) (x88=genericTypeParameterList{rtn.setGenericTypeParameterList(x88);})? (x89=type{rtn.setType(x89);}) (x90=IDENT{rtn.setIDENT($x90.text);}) (x91=formalParameterList{rtn.setFormalParameterList(x91);}) (x92=arrayDeclaratorList{rtn.setArrayDeclaratorList(x92);})? (x93=throwsClause{rtn.setThrowsClause(x93);})?)
|   ^(VOID_METHOD_DECL (x95=modifierList{rtn.setModifierList(x95);}) (x96=genericTypeParameterList{rtn.setGenericTypeParameterList(x96);})? (x97=IDENT{rtn.setIDENT($x97.text);}) (x98=formalParameterList{rtn.setFormalParameterList(x98);}) (x99=throwsClause{rtn.setThrowsClause(x99);})?)
|   ^(VAR_DECLARATION (x101=modifierList{rtn.setModifierList(x101);}) (x102=type{rtn.setType(x102);}) (x103=variableDeclaratorList{rtn.setVariableDeclaratorList(x103);}))
|   (x104=typeDeclaration{rtn.setTypeDeclaration(x104);})
;

variableDeclaratorList returns[VariableDeclaratorList rtn]
@init{rtn=new VariableDeclaratorList();}
:   ^(VAR_DECLARATOR_LIST (x106=variableDeclarator{rtn.addVariableDeclarator(x106);})+)
;

variableDeclarator returns[VariableDeclarator rtn]
@init{rtn=new VariableDeclarator();}
:   ^(VAR_DECLARATOR (x108=variableDeclaratorId{rtn.setVariableDeclaratorId(x108);}) (x109=variableInitializer{rtn.setVariableInitializer(x109);})?)
;

variableDeclaratorId returns[VariableDeclaratorId rtn]
@init{rtn=new VariableDeclaratorId();}
:   ^((x110=IDENT{rtn.setIDENT($x110.text);}) (x111=arrayDeclaratorList{rtn.setArrayDeclaratorList(x111);})?)
;

variableInitializer returns[VariableInitializer rtn]
@init{rtn=new VariableInitializer();}
:   (x112=arrayInitializer{rtn.setArrayInitializer(x112);})
|   (x113=expression{rtn.setExpression(x113);})
;

arrayDeclarator returns[ArrayDeclarator rtn]
@init{rtn=new ArrayDeclarator();}
:   (x114=LBRACK{rtn.setLBRACK($x114.text);}) (x115=RBRACK{rtn.setRBRACK($x115.text);})
;

arrayDeclaratorList returns[ArrayDeclaratorList rtn]
@init{rtn=new ArrayDeclaratorList();}
:   ^(ARRAY_DECLARATOR_LIST ARRAY_DECLARATOR*)
;

arrayInitializer returns[ArrayInitializer rtn]
@init{rtn=new ArrayInitializer();}
:   ^(ARRAY_INITIALIZER (x119=variableInitializer{rtn.addVariableInitializer(x119);})*)
;

throwsClause returns[ThrowsClause rtn]
@init{rtn=new ThrowsClause();}
:   ^(THROWS_CLAUSE (x121=qualifiedIdentifier{rtn.addQualifiedIdentifier(x121);})+)
;

modifierList returns[ModifierList rtn]
@init{rtn=new ModifierList();}
:   ^(MODIFIER_LIST (x123=modifier{rtn.addModifier(x123);})*)
;

modifier returns[Modifier rtn]
@init{rtn=new Modifier();}
:   (x124=PUBLIC{rtn.setPUBLIC($x124.text);})
|   (x125=PROTECTED{rtn.setPROTECTED($x125.text);})
|   (x126=PRIVATE{rtn.setPRIVATE($x126.text);})
|   (x127=STATIC{rtn.setSTATIC($x127.text);})
|   (x128=ABSTRACT{rtn.setABSTRACT($x128.text);})
|   (x129=NATIVE{rtn.setNATIVE($x129.text);})
|   (x130=SYNCHRONIZED{rtn.setSYNCHRONIZED($x130.text);})
|   (x131=TRANSIENT{rtn.setTRANSIENT($x131.text);})
|   (x132=VOLATILE{rtn.setVOLATILE($x132.text);})
|   (x133=STRICTFP{rtn.setSTRICTFP($x133.text);})
|   (x134=localModifier{rtn.setLocalModifier(x134);})
;

localModifierList returns[LocalModifierList rtn]
@init{rtn=new LocalModifierList();}
:   ^(LOCAL_MODIFIER_LIST (x136=localModifier{rtn.addLocalModifier(x136);})*)
;

localModifier returns[LocalModifier rtn]
@init{rtn=new LocalModifier();}
:   (x137=FINAL{rtn.setFINAL($x137.text);})
|   (x138=annotation{rtn.setAnnotation(x138);})
;

type returns[Type rtn]
@init{rtn=new Type();}
:   ^(TYPE ((x140=primitiveType{rtn.setPrimitiveType(x140);}) 
| (x141=qualifiedTypeIdent{rtn.setQualifiedTypeIdent(x141);})) (x142=arrayDeclaratorList{rtn.setArrayDeclaratorList(x142);})?)
;

qualifiedTypeIdent returns[QualifiedTypeIdent rtn]
@init{rtn=new QualifiedTypeIdent();}
:   ^(QUALIFIED_TYPE_IDENT (x144=typeIdent{rtn.addTypeIdent(x144);})+)
;

typeIdent returns[TypeIdent rtn]
@init{rtn=new TypeIdent();}
:   ^((x145=IDENT{rtn.setIDENT($x145.text);}) (x146=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x146);})?)
;

primitiveType returns[PrimitiveType rtn]
@init{rtn=new PrimitiveType();}
:   (x147=BOOLEAN{rtn.setBOOLEAN($x147.text);})
|   (x148=CHAR{rtn.setCHAR($x148.text);})
|   (x149=BYTE{rtn.setBYTE($x149.text);})
|   (x150=SHORT{rtn.setSHORT($x150.text);})
|   (x151=INT{rtn.setINT($x151.text);})
|   (x152=LONG{rtn.setLONG($x152.text);})
|   (x153=FLOAT{rtn.setFLOAT($x153.text);})
|   (x154=DOUBLE{rtn.setDOUBLE($x154.text);})
;

genericTypeArgumentList returns[GenericTypeArgumentList rtn]
@init{rtn=new GenericTypeArgumentList();}
:   ^(GENERIC_TYPE_ARG_LIST (x156=genericTypeArgument{rtn.addGenericTypeArgument(x156);})+)
;

genericTypeArgument returns[GenericTypeArgument rtn]
@init{rtn=new GenericTypeArgument();}
:   (x157=type{rtn.setType(x157);})
|   ^((x158=QUESTION{rtn.setQUESTION($x158.text);}) (x159=genericWildcardBoundType{rtn.setGenericWildcardBoundType(x159);})?)
;

genericWildcardBoundType returns[GenericWildcardBoundType rtn]
@init{rtn=new GenericWildcardBoundType();}
:   ^((x160=EXTENDS{rtn.setEXTENDS($x160.text);}) (x161=type{rtn.setType(x161);}))
|   ^((x162=SUPER{rtn.setSUPER($x162.text);}) (x163=type{rtn.setType(x163);}))
;

formalParameterList returns[FormalParameterList rtn]
@init{rtn=new FormalParameterList();}
:   ^(FORMAL_PARAM_LIST (x165=formalParameterStandardDecl{rtn.addFormalParameterStandardDecl(x165);})* (x166=formalParameterVarargDecl{rtn.setFormalParameterVarargDecl(x166);})?)
;

formalParameterStandardDecl returns[FormalParameterStandardDecl rtn]
@init{rtn=new FormalParameterStandardDecl();}
:   ^(FORMAL_PARAM_STD_DECL (x168=localModifierList{rtn.setLocalModifierList(x168);}) (x169=type{rtn.setType(x169);}) (x170=variableDeclaratorId{rtn.setVariableDeclaratorId(x170);}))
;

formalParameterVarargDecl returns[FormalParameterVarargDecl rtn]
@init{rtn=new FormalParameterVarargDecl();}
:   ^(FORMAL_PARAM_VARARG_DECL (x172=localModifierList{rtn.setLocalModifierList(x172);}) (x173=type{rtn.setType(x173);}) (x174=variableDeclaratorId{rtn.setVariableDeclaratorId(x174);}))
;

qualifiedIdentifier returns[QualifiedIdentifier rtn]
@init{rtn=new QualifiedIdentifier();}
:   (x175=IDENT{rtn.setIDENT($x175.text);})
|   ^((x176=DOT{rtn.setDOT($x176.text);}) (x177=qualifiedIdentifier{rtn.setQualifiedIdentifier(x177);}) (x178=IDENT{rtn.setIDENT($x178.text);}))
;

annotationList returns[AnnotationList rtn]
@init{rtn=new AnnotationList();}
:   ^(ANNOTATION_LIST (x180=annotation{rtn.addAnnotation(x180);})*)
;

annotation returns[Annotation rtn]
@init{rtn=new Annotation();}
:   ^((x181=AT{rtn.setAT($x181.text);}) (x182=qualifiedIdentifier{rtn.setQualifiedIdentifier(x182);}) (x183=annotationInit{rtn.setAnnotationInit(x183);})?)
;

annotationInit returns[AnnotationInit rtn]
@init{rtn=new AnnotationInit();}
:   ^(ANNOTATION_INIT_BLOCK (x185=annotationInitializers{rtn.setAnnotationInitializers(x185);}))
;

annotationInitializers returns[AnnotationInitializers rtn]
@init{rtn=new AnnotationInitializers();}
:   ^(ANNOTATION_INIT_KEY_LIST (x187=annotationInitializer{rtn.addAnnotationInitializer(x187);})+)
|   ^(ANNOTATION_INIT_DEFAULT_KEY (x189=annotationElementValue{rtn.setAnnotationElementValue(x189);}))
;

annotationInitializer returns[AnnotationInitializer rtn]
@init{rtn=new AnnotationInitializer();}
:   ^((x190=IDENT{rtn.setIDENT($x190.text);}) (x191=annotationElementValue{rtn.setAnnotationElementValue(x191);}))
;

annotationElementValue returns[AnnotationElementValue rtn]
@init{rtn=new AnnotationElementValue();}
:   ^(ANNOTATION_INIT_ARRAY_ELEMENT (x193=annotationElementValue{rtn.addAnnotationElementValue(x193);})*)
|   (x194=annotation{rtn.setAnnotation(x194);})
|   (x195=expression{rtn.setExpression(x195);})
;

annotationTopLevelScope returns[AnnotationTopLevelScope rtn]
@init{rtn=new AnnotationTopLevelScope();}
:   ^(ANNOTATION_TOP_LEVEL_SCOPE (x197=annotationScopeDeclarations{rtn.addAnnotationScopeDeclarations(x197);})*)
;

annotationScopeDeclarations returns[AnnotationScopeDeclarations rtn]
@init{rtn=new AnnotationScopeDeclarations();}
:   ^(ANNOTATION_METHOD_DECL (x199=modifierList{rtn.setModifierList(x199);}) (x200=type{rtn.setType(x200);}) (x201=IDENT{rtn.setIDENT($x201.text);}) (x202=annotationDefaultValue{rtn.setAnnotationDefaultValue(x202);})?)
|   ^(VAR_DECLARATION (x204=modifierList{rtn.setModifierList(x204);}) (x205=type{rtn.setType(x205);}) (x206=variableDeclaratorList{rtn.setVariableDeclaratorList(x206);}))
|   (x207=typeDeclaration{rtn.setTypeDeclaration(x207);})
;

annotationDefaultValue returns[AnnotationDefaultValue rtn]
@init{rtn=new AnnotationDefaultValue();}
:   ^((x208=DEFAULT{rtn.setDEFAULT($x208.text);}) (x209=annotationElementValue{rtn.setAnnotationElementValue(x209);}))
;

block returns[Block rtn]
@init{rtn=new Block();}
:   ^(BLOCK_SCOPE (x211=blockStatement{rtn.addBlockStatement(x211);})*)
;

blockStatement returns[BlockStatement rtn]
@init{rtn=new BlockStatement();}
:   (x212=localVariableDeclaration{rtn.setLocalVariableDeclaration(x212);})
|   (x213=typeDeclaration{rtn.setTypeDeclaration(x213);})
|   (x214=statement{rtn.setStatement(x214);})
;

localVariableDeclaration returns[LocalVariableDeclaration rtn]
@init{rtn=new LocalVariableDeclaration();}
:   ^(VAR_DECLARATION (x216=localModifierList{rtn.setLocalModifierList(x216);}) (x217=type{rtn.setType(x217);}) (x218=variableDeclaratorList{rtn.setVariableDeclaratorList(x218);}))
;

statement returns[Statement rtn]
@init{rtn=new Statement();}
:   (x219=block{rtn.setBlock(x219);})
|   ^((x220=ASSERT{rtn.setASSERT($x220.text);}) (x221=expression{rtn.setExpression(x221);}) (x222=expression{rtn.setExpression(x222);})?)
|   ^((x223=IF{rtn.setIF($x223.text);}) (x224=parenthesizedExpression{rtn.setParenthesizedExpression(x224);}) (x225=statement{rtn.setStatement(x225);}) (x226=statement{rtn.setStatement(x226);})?)
|   ^((x227=FOR{rtn.setFOR($x227.text);}) (x228=forInit{rtn.setForInit(x228);}) (x229=forCondition{rtn.setForCondition(x229);}) (x230=forUpdater{rtn.setForUpdater(x230);}) (x231=statement{rtn.setStatement(x231);}))
|   ^(FOR_EACH (x233=localModifierList{rtn.setLocalModifierList(x233);}) (x234=type{rtn.setType(x234);}) (x235=IDENT{rtn.setIDENT($x235.text);}) (x236=expression{rtn.setExpression(x236);}) (x237=statement{rtn.setStatement(x237);}))
|   ^((x238=WHILE{rtn.setWHILE($x238.text);}) (x239=parenthesizedExpression{rtn.setParenthesizedExpression(x239);}) (x240=statement{rtn.setStatement(x240);}))
|   ^((x241=DO{rtn.setDO($x241.text);}) (x242=statement{rtn.setStatement(x242);}) (x243=parenthesizedExpression{rtn.setParenthesizedExpression(x243);}))
|   ^((x244=TRY{rtn.setTRY($x244.text);}) (x245=block{rtn.setBlock(x245);}) (x246=catches{rtn.setCatches(x246);})? (x247=block{rtn.setBlock(x247);})?)
|   ^((x248=SWITCH{rtn.setSWITCH($x248.text);}) (x249=parenthesizedExpression{rtn.setParenthesizedExpression(x249);}) (x250=switchBlockLabels{rtn.setSwitchBlockLabels(x250);}))
|   ^((x251=SYNCHRONIZED{rtn.setSYNCHRONIZED($x251.text);}) (x252=parenthesizedExpression{rtn.setParenthesizedExpression(x252);}) (x253=block{rtn.setBlock(x253);}))
|   ^((x254=RETURN{rtn.setRETURN($x254.text);}) (x255=expression{rtn.setExpression(x255);})?)
|   ^((x256=THROW{rtn.setTHROW($x256.text);}) (x257=expression{rtn.setExpression(x257);}))
|   ^((x258=BREAK{rtn.setBREAK($x258.text);}) (x259=IDENT{rtn.setIDENT($x259.text);})?)
|   ^((x260=CONTINUE{rtn.setCONTINUE($x260.text);}) (x261=IDENT{rtn.setIDENT($x261.text);})?)
|   ^(LABELED_STATEMENT (x263=IDENT{rtn.setIDENT($x263.text);}) (x264=statement{rtn.setStatement(x264);}))
|   (x265=expression{rtn.setExpression(x265);})
|   (x266=SEMI{rtn.setSEMI($x266.text);})
;

catches returns[Catches rtn]
@init{rtn=new Catches();}
:   ^(CATCH_CLAUSE_LIST (x268=catchClause{rtn.addCatchClause(x268);})+)
;

catchClause returns[CatchClause rtn]
@init{rtn=new CatchClause();}
:   ^((x269=CATCH{rtn.setCATCH($x269.text);}) (x270=formalParameterStandardDecl{rtn.setFormalParameterStandardDecl(x270);}) (x271=block{rtn.setBlock(x271);}))
;

switchBlockLabels returns[SwitchBlockLabels rtn]
@init{rtn=new SwitchBlockLabels();}
:   ^(SWITCH_BLOCK_LABEL_LIST (x273=switchCaseLabel{rtn.addSwitchCaseLabel(x273);})* (x274=switchDefaultLabel{rtn.setSwitchDefaultLabel(x274);})? (x275=switchCaseLabel{rtn.addSwitchCaseLabel(x275);})*)
;

switchCaseLabel returns[SwitchCaseLabel rtn]
@init{rtn=new SwitchCaseLabel();}
:   ^((x276=CASE{rtn.setCASE($x276.text);}) (x277=expression{rtn.setExpression(x277);}) (x278=blockStatement{rtn.addBlockStatement(x278);})*)
;

switchDefaultLabel returns[SwitchDefaultLabel rtn]
@init{rtn=new SwitchDefaultLabel();}
:   ^((x279=DEFAULT{rtn.setDEFAULT($x279.text);}) (x280=blockStatement{rtn.addBlockStatement(x280);})*)
;

forInit returns[ForInit rtn]
@init{rtn=new ForInit();}
:   ^(FOR_INIT ((x282=localVariableDeclaration{rtn.setLocalVariableDeclaration(x282);}) 
| (x283=expression{rtn.addExpression(x283);})*)?)
;

forCondition returns[ForCondition rtn]
@init{rtn=new ForCondition();}
:   ^(FOR_CONDITION (x285=expression{rtn.setExpression(x285);})?)
;

forUpdater returns[ForUpdater rtn]
@init{rtn=new ForUpdater();}
:   ^(FOR_UPDATE (x287=expression{rtn.addExpression(x287);})*)
;

parenthesizedExpression returns[ParenthesizedExpression rtn]
@init{rtn=new ParenthesizedExpression();}
:   ^(PARENTESIZED_EXPR (x289=expression{rtn.setExpression(x289);}))
;

expression returns[Expression rtn]
@init{rtn=new Expression();}
:   ^(EXPR (x291=expr{rtn.setExpr(x291);}))
;

expr returns[Expr rtn]
@init{rtn=new Expr();}
:   ^((x292=ASSIGN{rtn.setASSIGN($x292.text);}) (x293=expr{rtn.setExpr(x293);}) (x294=expr{rtn.setExpr(x294);}))
|   ^((x295=PLUS_ASSIGN{rtn.setPLUS_ASSIGN($x295.text);}) (x296=expr{rtn.setExpr(x296);}) (x297=expr{rtn.setExpr(x297);}))
|   ^((x298=MINUS_ASSIGN{rtn.setMINUS_ASSIGN($x298.text);}) (x299=expr{rtn.setExpr(x299);}) (x300=expr{rtn.setExpr(x300);}))
|   ^((x301=STAR_ASSIGN{rtn.setSTAR_ASSIGN($x301.text);}) (x302=expr{rtn.setExpr(x302);}) (x303=expr{rtn.setExpr(x303);}))
|   ^((x304=DIV_ASSIGN{rtn.setDIV_ASSIGN($x304.text);}) (x305=expr{rtn.setExpr(x305);}) (x306=expr{rtn.setExpr(x306);}))
|   ^((x307=AND_ASSIGN{rtn.setAND_ASSIGN($x307.text);}) (x308=expr{rtn.setExpr(x308);}) (x309=expr{rtn.setExpr(x309);}))
|   ^((x310=OR_ASSIGN{rtn.setOR_ASSIGN($x310.text);}) (x311=expr{rtn.setExpr(x311);}) (x312=expr{rtn.setExpr(x312);}))
|   ^((x313=XOR_ASSIGN{rtn.setXOR_ASSIGN($x313.text);}) (x314=expr{rtn.setExpr(x314);}) (x315=expr{rtn.setExpr(x315);}))
|   ^((x316=MOD_ASSIGN{rtn.setMOD_ASSIGN($x316.text);}) (x317=expr{rtn.setExpr(x317);}) (x318=expr{rtn.setExpr(x318);}))
|   ^((x319=BIT_SHIFT_RIGHT_ASSIGN{rtn.setBIT_SHIFT_RIGHT_ASSIGN($x319.text);}) (x320=expr{rtn.setExpr(x320);}) (x321=expr{rtn.setExpr(x321);}))
|   ^((x322=SHIFT_RIGHT_ASSIGN{rtn.setSHIFT_RIGHT_ASSIGN($x322.text);}) (x323=expr{rtn.setExpr(x323);}) (x324=expr{rtn.setExpr(x324);}))
|   ^((x325=SHIFT_LEFT_ASSIGN{rtn.setSHIFT_LEFT_ASSIGN($x325.text);}) (x326=expr{rtn.setExpr(x326);}) (x327=expr{rtn.setExpr(x327);}))
|   ^((x328=QUESTION{rtn.setQUESTION($x328.text);}) (x329=expr{rtn.setExpr(x329);}) (x330=expr{rtn.setExpr(x330);}) (x331=expr{rtn.setExpr(x331);}))
|   ^((x332=LOGICAL_OR{rtn.setLOGICAL_OR($x332.text);}) (x333=expr{rtn.setExpr(x333);}) (x334=expr{rtn.setExpr(x334);}))
|   ^((x335=LOGICAL_AND{rtn.setLOGICAL_AND($x335.text);}) (x336=expr{rtn.setExpr(x336);}) (x337=expr{rtn.setExpr(x337);}))
|   ^((x338=OR{rtn.setOR($x338.text);}) (x339=expr{rtn.setExpr(x339);}) (x340=expr{rtn.setExpr(x340);}))
|   ^((x341=XOR{rtn.setXOR($x341.text);}) (x342=expr{rtn.setExpr(x342);}) (x343=expr{rtn.setExpr(x343);}))
|   ^((x344=AND{rtn.setAND($x344.text);}) (x345=expr{rtn.setExpr(x345);}) (x346=expr{rtn.setExpr(x346);}))
|   ^((x347=EQUAL{rtn.setEQUAL($x347.text);}) (x348=expr{rtn.setExpr(x348);}) (x349=expr{rtn.setExpr(x349);}))
|   ^((x350=NOT_EQUAL{rtn.setNOT_EQUAL($x350.text);}) (x351=expr{rtn.setExpr(x351);}) (x352=expr{rtn.setExpr(x352);}))
|   ^((x353=INSTANCEOF{rtn.setINSTANCEOF($x353.text);}) (x354=expr{rtn.setExpr(x354);}) (x355=type{rtn.setType(x355);}))
|   ^((x356=LESS_OR_EQUAL{rtn.setLESS_OR_EQUAL($x356.text);}) (x357=expr{rtn.setExpr(x357);}) (x358=expr{rtn.setExpr(x358);}))
|   ^((x359=GREATER_OR_EQUAL{rtn.setGREATER_OR_EQUAL($x359.text);}) (x360=expr{rtn.setExpr(x360);}) (x361=expr{rtn.setExpr(x361);}))
|   ^((x362=BIT_SHIFT_RIGHT{rtn.setBIT_SHIFT_RIGHT($x362.text);}) (x363=expr{rtn.setExpr(x363);}) (x364=expr{rtn.setExpr(x364);}))
|   ^((x365=SHIFT_RIGHT{rtn.setSHIFT_RIGHT($x365.text);}) (x366=expr{rtn.setExpr(x366);}) (x367=expr{rtn.setExpr(x367);}))
|   ^((x368=GREATER_THAN{rtn.setGREATER_THAN($x368.text);}) (x369=expr{rtn.setExpr(x369);}) (x370=expr{rtn.setExpr(x370);}))
|   ^((x371=SHIFT_LEFT{rtn.setSHIFT_LEFT($x371.text);}) (x372=expr{rtn.setExpr(x372);}) (x373=expr{rtn.setExpr(x373);}))
|   ^((x374=LESS_THAN{rtn.setLESS_THAN($x374.text);}) (x375=expr{rtn.setExpr(x375);}) (x376=expr{rtn.setExpr(x376);}))
|   ^((x377=PLUS{rtn.setPLUS($x377.text);}) (x378=expr{rtn.setExpr(x378);}) (x379=expr{rtn.setExpr(x379);}))
|   ^((x380=MINUS{rtn.setMINUS($x380.text);}) (x381=expr{rtn.setExpr(x381);}) (x382=expr{rtn.setExpr(x382);}))
|   ^((x383=STAR{rtn.setSTAR($x383.text);}) (x384=expr{rtn.setExpr(x384);}) (x385=expr{rtn.setExpr(x385);}))
|   ^((x386=DIV{rtn.setDIV($x386.text);}) (x387=expr{rtn.setExpr(x387);}) (x388=expr{rtn.setExpr(x388);}))
|   ^((x389=MOD{rtn.setMOD($x389.text);}) (x390=expr{rtn.setExpr(x390);}) (x391=expr{rtn.setExpr(x391);}))
|   ^(UNARY_PLUS (x393=expr{rtn.setExpr(x393);}))
|   ^(UNARY_MINUS (x395=expr{rtn.setExpr(x395);}))
|   ^(PRE_INC (x397=expr{rtn.setExpr(x397);}))
|   ^(PRE_DEC (x399=expr{rtn.setExpr(x399);}))
|   ^(POST_INC (x401=expr{rtn.setExpr(x401);}))
|   ^(POST_DEC (x403=expr{rtn.setExpr(x403);}))
|   ^((x404=NOT{rtn.setNOT($x404.text);}) (x405=expr{rtn.setExpr(x405);}))
|   ^((x406=LOGICAL_NOT{rtn.setLOGICAL_NOT($x406.text);}) (x407=expr{rtn.setExpr(x407);}))
|   ^(CAST_EXPR (x409=type{rtn.setType(x409);}) (x410=expr{rtn.setExpr(x410);}))
|   (x411=primaryExpression{rtn.setPrimaryExpression(x411);})
;

primaryExpression returns[PrimaryExpression rtn]
@init{rtn=new PrimaryExpression();}
:   ^(  (x412=DOT{rtn.setDOT($x412.text);})(   (x413=primaryExpression{rtn.setPrimaryExpression(x413);})(   (x414=IDENT{rtn.setIDENT($x414.text);})
|   (x415=THIS{rtn.setTHIS($x415.text);})
|   (x416=SUPER{rtn.setSUPER($x416.text);})
|   (x417=innerNewExpression{rtn.setInnerNewExpression(x417);})
|   (x418=CLASS{rtn.setCLASS($x418.text);}))
|   (x419=primitiveType{rtn.setPrimitiveType(x419);}) (x420=CLASS{rtn.setCLASS($x420.text);})
|   (x421=VOID{rtn.setVOID($x421.text);}) (x422=CLASS{rtn.setCLASS($x422.text);})))
|   (x423=parenthesizedExpression{rtn.setParenthesizedExpression(x423);})
|   (x424=IDENT{rtn.setIDENT($x424.text);})
|   ^(METHOD_CALL (x426=primaryExpression{rtn.setPrimaryExpression(x426);}) (x427=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x427);})? (x428=arguments{rtn.setArguments(x428);}))
|   (x429=explicitConstructorCall{rtn.setExplicitConstructorCall(x429);})
|   ^(ARRAY_ELEMENT_ACCESS (x431=primaryExpression{rtn.setPrimaryExpression(x431);}) (x432=expression{rtn.setExpression(x432);}))
|   (x433=literal{rtn.setLiteral(x433);})
|   (x434=newExpression{rtn.setNewExpression(x434);})
|   (x435=THIS{rtn.setTHIS($x435.text);})
|   (x436=arrayTypeDeclarator{rtn.setArrayTypeDeclarator(x436);})
|   (x437=SUPER{rtn.setSUPER($x437.text);})
;

explicitConstructorCall returns[ExplicitConstructorCall rtn]
@init{rtn=new ExplicitConstructorCall();}
:   ^(THIS_CONSTRUCTOR_CALL (x439=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x439);})? (x440=arguments{rtn.setArguments(x440);}))
|   ^(SUPER_CONSTRUCTOR_CALL (x442=primaryExpression{rtn.setPrimaryExpression(x442);})? (x443=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x443);})? (x444=arguments{rtn.setArguments(x444);}))
;

arrayTypeDeclarator returns[ArrayTypeDeclarator rtn]
@init{rtn=new ArrayTypeDeclarator();}
:   ^(ARRAY_DECLARATOR ((x446=arrayTypeDeclarator{rtn.setArrayTypeDeclarator(x446);}) 
| (x447=qualifiedIdentifier{rtn.setQualifiedIdentifier(x447);}) 
| (x448=primitiveType{rtn.setPrimitiveType(x448);})))
;

newExpression returns[NewExpression rtn]
@init{rtn=new NewExpression();}
:   ^(  STATIC_ARRAY_CREATOR(   (x450=primitiveType{rtn.setPrimitiveType(x450);}) (x451=newArrayConstruction{rtn.setNewArrayConstruction(x451);})
|   (x452=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x452);})? (x453=qualifiedTypeIdent{rtn.setQualifiedTypeIdent(x453);}) (x454=newArrayConstruction{rtn.setNewArrayConstruction(x454);})))
|   ^(CLASS_CONSTRUCTOR_CALL (x456=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x456);})? (x457=qualifiedTypeIdent{rtn.setQualifiedTypeIdent(x457);}) (x458=arguments{rtn.setArguments(x458);}) (x459=classTopLevelScope{rtn.setClassTopLevelScope(x459);})?)
;

innerNewExpression returns[InnerNewExpression rtn]
@init{rtn=new InnerNewExpression();}
:   ^(CLASS_CONSTRUCTOR_CALL (x461=genericTypeArgumentList{rtn.setGenericTypeArgumentList(x461);})? (x462=IDENT{rtn.setIDENT($x462.text);}) (x463=arguments{rtn.setArguments(x463);}) (x464=classTopLevelScope{rtn.setClassTopLevelScope(x464);})?)
;

newArrayConstruction returns[NewArrayConstruction rtn]
@init{rtn=new NewArrayConstruction();}
:   (x465=arrayDeclaratorList{rtn.setArrayDeclaratorList(x465);}) (x466=arrayInitializer{rtn.setArrayInitializer(x466);})
|   (x467=expression{rtn.addExpression(x467);})+ (x468=arrayDeclaratorList{rtn.setArrayDeclaratorList(x468);})?
;

arguments returns[Arguments rtn]
@init{rtn=new Arguments();}
:   ^(ARGUMENT_LIST (x470=expression{rtn.addExpression(x470);})*)
;

literal returns[Literal rtn]
@init{rtn=new Literal();}
:   (x471=HEX_LITERAL{rtn.setHEX_LITERAL($x471.text);})
|   (x472=OCTAL_LITERAL{rtn.setOCTAL_LITERAL($x472.text);})
|   (x473=DECIMAL_LITERAL{rtn.setDECIMAL_LITERAL($x473.text);})
|   (x474=FLOATING_POINT_LITERAL{rtn.setFLOATING_POINT_LITERAL($x474.text);})
|   (x475=CHARACTER_LITERAL{rtn.setCHARACTER_LITERAL($x475.text);})
|   (x476=STRING_LITERAL{rtn.setSTRING_LITERAL($x476.text);})
|   (x477=TRUE{rtn.setTRUE($x477.text);})
|   (x478=FALSE{rtn.setFALSE($x478.text);})
|   (x479=NULL{rtn.setNULL($x479.text);})
;



    