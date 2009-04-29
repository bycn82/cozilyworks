import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
	public void testLiteral() throws RecognitionException{
		str="abc";
		trace(getParser(readString(str).literal().getTree()).literal());
	}
	public void testPrimitiveType() throws RecognitionException{
		str="boolean ";
		trace(getParser(readString(str).primitiveType().getTree()).primitiveType());
	}
}
