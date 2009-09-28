import java.io.File;
import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
//	public void testExample() throws RecognitionException{
//	str="10+12";
//	trace(getParser(readString(str).EXAMPLE().getTree()).EXAMPLE());
//  }
	
	public void testReturnLiteral() throws RecognitionException{
		File f=new File("src/example");
		System.out.println(f.exists());
		trace(getParser(readFile(f).program().getTree()).program());
	}
}
