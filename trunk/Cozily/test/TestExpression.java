import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
	public void testClassBlock() throws RecognitionException{
		str="public";
		step2(step1(str).literal().getTree()).literal();
	}
}
