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
	:^(name=ID modi=MODIFIER  ^( s=newstatement'{' '}'))
	{
	m=new MethodDom();
	m.setModifier($modi.text);
	m.setName($name.text);
	m.addStatement($s.ns);
	}
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
