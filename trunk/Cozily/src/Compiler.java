import java.io.File;
import java.io.FileInputStream;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Compiler{
	public static void main(String[] args) throws Exception{
		// Create an input character stream from standard in
		ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(new File("Cozily.as")));
		// Create an ExprLexer that feeds from that stream
		CozilyLexer lexer=new CozilyLexer(input);
		// Create a stream of tokens fed by the lexer
		CommonTokenStream tokens=new CommonTokenStream(lexer);
		// Create a parser that feeds off the token stream
		CozilyParser parser=new CozilyParser(tokens);
		// Begin parsing at rule prog, get return value structure
		CozilyParser.program_return r=parser.program();
		// WALK RESULTING TREE
		CommonTree t=(CommonTree)r.getTree(); // get tree from parser
		// Create a tree node stream from resulting tree
		CommonTreeNodeStream nodes=new CommonTreeNodeStream(t);
		CozilyTree walker=new CozilyTree(nodes); // create a tree parser
		System.out.println(walker.program());// launch at start rule prog
	}
}
