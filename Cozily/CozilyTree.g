tree grammar CozilyTree;

options {
    tokenVocab=Cozily;
    ASTLabelType=CommonTree;
}

@header {
import com.cozilyworks.cozily.compiler.codedom.*;
}

@members {

}
// $<CLASS LEVEL

// $>
// $<STATEMENT LEVEL
methodstatement returns[MethodDom m]
	@init{m=new MethodDom();}
	:^(returnType=ID modi=MODIFIER ^(name=ID ^('(){' nss=newstatements '}')))
	{
	m.setModifier($modi.text);
	m.setName($name.text);
	m.setReturnType($returnType.text);
	m.addAll($nss.ls);
	}
	;
newstatements returns[List<NewStatement> ls]
	@init{ ls=new ArrayList<NewStatement>();}
	:(ns=newstatement
	{
	ls.add($ns.ns);
	})+
	;

newstatement returns[NewStatement ns]
	:	^('=' ^(type=ID id=ID) ^(NEW ID '();'))	
	{	
		ns=new NewStatement();
		ns.setName($id.text);
		ns.setType($type.text);
	}
	;
// $>
