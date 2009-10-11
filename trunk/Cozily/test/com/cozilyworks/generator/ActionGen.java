package com.cozilyworks.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cozilyworks.cozily.codedom.CodeDocument;
import com.cozilyworks.util.StringUtil;
import com.cozilyworks.util.TestUtil;

public class ActionGen{
	public static List<String> tokens=new ArrayList<String>();
	public static boolean showToken=false;
	public static BufferedWriter writer;
	public static Pattern p=Pattern.compile("([a-zA-Z_]*)");
	public static int i=0;
	public static List<Clz> clzs=new ArrayList<Clz>();
	private static void compile(String src,String dest) throws IOException{
		File srcf=new File(src);
		File destf=new File(dest);
		BufferedReader reader=new BufferedReader(new FileReader(srcf));
		writer=new BufferedWriter(new FileWriter(destf));
		String line=reader.readLine();
		Clz clz=null;
		while(line!=null){
			// ////////////////////////////////////////////
			line=line.trim();
			// System.out.print(line);
			if(!line.equals("")){
				if(line.startsWith(":")||line.startsWith("|")||line.startsWith(";")||line.startsWith("(")
					||line.startsWith(")")||line.startsWith("^")){
					// //////////rule
					Matcher m=p.matcher(line);
					int begin=0;
					int end=0;
					while(m.find()){
						begin=m.start();
						trace(line.substring(end,begin).replace("|","\n|").replace(";","\n;"));
						String rule=m.group();
						if(rule.length()>0){
							i++;
							if(tokens.contains(rule)){
								trace(rule);
							}else{
								int pos=m.end();
								String method="set";
								if(line.length()>pos){
									String x=line.substring(pos,pos+1);
									if(x.equalsIgnoreCase("+")||x.equalsIgnoreCase("*")){
										method="add";
									}
								}
								Med med=new Med();
								if(StringUtil.isUpperCase(rule,"_")){
									trace("(x"+i+"="+rule+"{rtn."+method+TestUtil.ucword(rule)+"($x"+i+".text);})");
									med.setName(method+TestUtil.ucword(rule));
									med.setType("String");
								}else{
									trace("(x"+i+"="+rule+"{rtn."+method+TestUtil.ucword(rule)+"(x"+i+");})");
									med.setName(method+TestUtil.ucword(rule));
									med.setType(TestUtil.ucword(rule));
								}
								//check whether can add this method
								boolean can=true;
								for(Med temp:clz.getMeds()){
									if(temp.getName().equals(med.getName())){
										can=false;
									}
								}
								if(can)
									clz.addMed(med);
							}
						}
						end=m.end();
					}
					trace(line.substring(end));
					if(line.startsWith(";")){
						trace("\n\n");
					}
				}else{
					// /////////ruleName
					clz=new Clz();
					String ruleClassName=TestUtil.ucword(line);
					trace(line+" returns["+ruleClassName+" rtn]\n");
					trace("@init{rtn=new "+ruleClassName+"();}\n");
					clz.setName(ruleClassName);
				}
				clzs.add(clz);
			}
			// ///////////////////////////////////////////////
			line=reader.readLine();
		}
		writer.flush();
		generClz();
	}
	private static void generClz() throws IOException{
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
						w.write("private List<"+med.getType()+"> "+med.getType().toLowerCase()+"s=new ArrayList<"+med.getType()+">();\n");
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
	private static void initTokens(String path) throws IOException{
		File file=new File(path);
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String line=reader.readLine();
		while(line!=null){
			tokens.add(line.trim().replace(";",""));
			line=reader.readLine();
		}
		if(showToken){
			for(String token:tokens){
				System.err.println(token);
			}
		}
	}
	public static void main(String[] args) throws IOException{
		initTokens("test/tokens.txt");
		compile("test/actions.txt","test/dest.txt");
	}
	public static void trace(String str) throws IOException{
		System.out.print(str);
		writer.write(str);
	}
}
