package com.cozilyworks.code.generator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class CodeDomGenerator{
	private static void generClz(List<Clz> clzs) throws IOException{
		String folder="src\\com\\cozilyworks\\cozily\\codedom\\impl";
		for(Clz clz:clzs){
			if(clz!=null){
				String clzName=clz.getName();
				File f=new File(folder+"\\"+clzName+".java");
				BufferedWriter w=new BufferedWriter(new FileWriter(f));
				w.write("package com.cozilyworks.cozily.codedom.impl;\n");
				w.write("import java.util.ArrayList;\n");
				w.write("import java.util.List;\n");
				w.write("import com.cozilyworks.cozily.codedom.*;\n");
				w.write("public class "+clzName+" extends CodeDocument{\n");
				int i=0;
				for(Med med:clz.getMeds()){
					i++;
					System.out.println(clzName+" "+med.getName());
					if(med.getName().startsWith("set")){
						w.write("private "+med.getType()+" "+med.getType().toLowerCase()+i+";\n");
						w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
						w.write("this."+med.getType().toLowerCase()+i+"=t;\n");
						w.write("}\n");
					}else{
						w.write("private List<"+med.getType()+"> "+med.getType().toLowerCase()+"s=new ArrayList<"
								+med.getType()+">();\n");
						w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
						w.write("this."+med.getType().toLowerCase()+"s.add(t);\n");
						w.write("}\n");
					}
				}
				w.write("}\n");
				w.flush();
			}
		}
	}
}
