import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str="";
	public void testParametersExpression() throws RecognitionException{
		str="a,b";
		trace(step2(step1(str).parametersexpression().getTree()).parametersexpression().visit());
	}
	public void testArgumentsExpression() throws RecognitionException{
		str="String s,int i";
		trace(step2(step1(str).argumentsexpression().getTree()).argumentsexpression().visit());
	}
	public void testNewExpression() throws RecognitionException{
		str="new String(abc)";
		trace(step2(step1(str).newexpression().getTree()).newexpression().visit());
	}
	public void testDefineStatement() throws RecognitionException{
		str="String str=new String(abc);";
		trace(step2(step1(str).definestatement().getTree()).definestatement().visit());
	}
	public void testMethodBlock() throws RecognitionException{
		str="public String getName(){"
			+"\nString str=new String(abc);" +
					"}";
		trace(step2(step1(str).methodblock().getTree()).methodblock().visit());
	}
	public void testClassBlock() throws RecognitionException{
		str="public class Google{" +
				"public String getName(){" +
				"String str=new String(abc);" +
				"String str=new String(abc);" +
				"String str=new String(abc);" +
				"}" +
				"public String getName(){" +
				"String str=new String(abc);" +
				"}" +
				"}";
		trace(step2(step1(str).classblock().getTree()).classblock().visit());
	}
}
