import java.io.StringReader;
import junit.framework.TestCase;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class BaseTestCase extends TestCase{
	public void trace(Object o){
		System.out.println(o);
	}
	public CozilyParser step1(String str){
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
	public CozilyTreeParser step2(Object o){
		CommonTreeNodeStream nodes=new CommonTreeNodeStream((CommonTree)o);
		return new CozilyTreeParser(nodes);
	}
}
