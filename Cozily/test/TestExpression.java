import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str="";
	public void testArgumentExpression() throws RecognitionException{
		str="String a";
		trace(step2(step1(str).expression().getTree()).expression());
	}
}
