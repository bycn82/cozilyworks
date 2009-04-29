import java.io.File;
import org.antlr.runtime.RecognitionException;

public class TestExpression extends BaseTestCase{
	public String str;
	public void testClassBlock() throws RecognitionException{
		str="int i";
		getParser(readString(str).getINT().getTree()).getINT();
	}
//	public void testAll() throws RecognitionException{
//		str="D:/Temp";
//		File dir=new File(str);
//		File[] files=dir.listFiles();
//		for(File file:files){
//			getParser(readFile(file).javaSource().getTree()).javaSource();
//		}
//	}
}
