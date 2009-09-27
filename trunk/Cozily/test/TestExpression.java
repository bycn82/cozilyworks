import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
	public void testLiteral() throws RecognitionException{
		str="10+12";
		getParser(readString(str).add().getTree()).add();
	}
}
