package com.cozilyworks.code.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.util.StringUtilPlus;

public class CodeDomGen{
	public static List<String> medNames;
	public static void parse(List<Clz> clzs){
		try{
			String folder="src\\com\\cozilyworks\\cozily\\codedom\\impl";
			for(Clz clz:clzs){
				if(clz!=null){
					String clzName=StringUtilPlus.ucword(clz.getName());
					File f=new File(folder+"\\"+clzName+".java");
					BufferedWriter w=new BufferedWriter(new FileWriter(f));
					w.write("package com.cozilyworks.cozily.codedom.impl;\n");
					w.write("import java.util.ArrayList;\n");
					w.write("import java.util.List;\n");
					w.write("import com.cozilyworks.cozily.codedom.*;\n");
					w.write("public class "+clzName+" extends CodeDocument{\n");
					medNames=new ArrayList<String>();
					for(Med med:clz.getMeds()){
						if(notRepeat(med)){
							if(med.getType().equals("String")){
								if(med.getName().startsWith("set")){
									w.write("private String "+med.getName().toLowerCase().substring(3)+"Str;\n");
									w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
									w.write("this."+med.getName().toLowerCase().substring(3)+"Str=t;\n");
									w.write("}\n");
								}else{
									w.write("private List<String> "+med.getName().toLowerCase().substring(3)+"s=new ArrayList<String>();\n");
									w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
									w.write("this."+med.getName().toLowerCase().substring(3)+"s.add(t);\n");
									w.write("}\n");
								}
							}else{
								if(med.getName().startsWith("set")){
									w.write("private "+med.getType()+" "+med.getType().toLowerCase()+";\n");
									w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
									w.write("this."+med.getType().toLowerCase()+"=t;\n");
									w.write("}\n");
								}else{
									w.write("private List<"+med.getType()+"> "+med.getType().toLowerCase()
										+"s=new ArrayList<"+med.getType()+">();\n");
									w.write("public void "+med.getName()+"("+med.getType()+" t){\n");
									w.write("this."+med.getType().toLowerCase()+"s.add(t);\n");
									w.write("}\n");
								}
							}
						}
					}
					w.write("}\n");
					w.flush();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static boolean notRepeat(Med med){
		if(medNames.contains(med.getName())){
			medNames.add(med.getName());
			return false;
		}else{
			medNames.add(med.getName());
			return true;
		}
	}
}
