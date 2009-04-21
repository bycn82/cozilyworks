import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Compiler {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(readFile("./Cozily.as"));
		CozilyLexer lexer = new CozilyLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CozilyParser parser = new CozilyParser(tokens);
		//CozilyParser.newstatement_return rtn = parser.newstatement();
		CozilyParser.methodstatement_return rtn=parser.methodstatement();
		CommonTree t = (CommonTree) rtn.getTree();
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		CozilyTree walker = new CozilyTree(nodes);
		//System.out.println(walker.newstatement());
		System.out.println(walker.methodstatement());
	}

	public static InputStream readFile(String path) {
		try {
			return new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
