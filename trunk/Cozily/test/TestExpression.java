import java.io.File;
import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
	public void testClassBlock() throws RecognitionException{
		str="'A'";
		getParser(readString(str).literal().getTree()).literal();
		str="0x122";
		getParser(readString(str).literal().getTree()).literal();
		str="\"ab c\"";
		getParser(readString(str).literal().getTree()).literal();
		str="123";
		getParser(readString(str).literal().getTree()).literal();
		str="1.2@";
		getParser(readString(str).literal().getTree()).literal();
	}
	public void testAll() throws RecognitionException{
		str="D:/Temp";
		File dir=new File(str);
		File[] files=dir.listFiles();
		for(File file:files){
			getParser(readFile(file).javaSource().getTree()).javaSource();
		}
	}
}
