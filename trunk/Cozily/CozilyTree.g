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
program	returns [ProgramDom p]:
	^('class' MODIFIER ^('{' ID '}'))
	{
	p=new ProgramDom();
	p.setName($ID.text);
	}
	;
// $>
// $<STATEMENT LEVEL

// $>
