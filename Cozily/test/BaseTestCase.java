import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import com.cozilyworks.cozily.parser.CozilyLexer;
import com.cozilyworks.cozily.parser.CozilyParser;
import com.cozilyworks.cozily.parser.CozilyTreeParser;

public class BaseTestCase extends TestCase{
	public void trace(Object o){
		System.out.println(o);
	}
	public CozilyParser readString(String str){
		try{
			ANTLRInputStream input=new ANTLRInputStream();
			input.load(new StringReader(str),0,str.getBytes().length);
			CozilyLexer lexer=new CozilyLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			return new CozilyParser(tokens);
		}catch(Exception e){
			trace(e);
		}
		return null;
	}
	public CozilyParser readFile(File file){
		try{
			ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(file));
			CozilyLexer lexer=new CozilyLexer(input);
			CommonTokenStream tokens=new CommonTokenStream(lexer);
			return new CozilyParser(tokens);
		}catch(Exception e){
			trace(e);
		}
		return null;
	}
	public CozilyTreeParser getParser(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
}
