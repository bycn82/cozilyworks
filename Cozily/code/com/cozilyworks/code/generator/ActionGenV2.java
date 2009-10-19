package com.cozilyworks.code.generator;
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
import com.cozilyworks.cozily.util.StringUtil;
import com.cozilyworks.cozily.util.StringUtilPlus;
/**
 * 直接从new rules里获得Tree Grammer,并且得到Visit,采用String.format来实现
 */
public class ActionGenV2{
	private static String from=Constants.NEW_RULES_PATH;
	private static String to=Constants.ACTION_V2;
	private static List<String> formats=new ArrayList<String>();
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static Pattern p=Pattern.compile("([A-Za-z0-9]*)");
	public static List<String> imaginarys=new ArrayList<String>();
	public static String imaginaryTxt=Constants.IMAGINARY_PATH;
	public static List<Clz> clzs=new ArrayList<Clz>();
	public static Clz clz;
	public static int i=0;
	public static void analyse(){
		try{
			String line=reader.readLine();
			while(line!=null){
				if(isRule(line)){
					doRule(line);
				}else{
					doRuleName(line);
				}
				line=reader.readLine();
			}
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void doRuleName(String ruleName){
		ruleName=ruleName.trim();
		write(String.format("%s returns[%s rtn]\n@init{rtn=new %s();}\n",ruleName,StringUtilPlus.ucword(ruleName),
				StringUtilPlus.ucword(ruleName)));
		clz=new Clz();
		clz.setName(ruleName);
	}
	private static void doRule(String rule){
		rule=rule.trim();
		if(rule.startsWith(";")){
			// 就是 只有分号的一行
			write(";\n\n");
			// 收集class
			if(clz!=null){
				clzs.add(clz);
			}
			i=0;
		}
		if(rule.startsWith("->")){
			rule=rule.replace("->","");
			Matcher m=p.matcher(rule);
			int start=0,end=0;
			StringBuilder sb=new StringBuilder();
			while(m.find()){
				String now=m.group();
				end=m.start();
				sb.append(rule.substring(start,end));
				start=m.end();
				if(now.length()!=0){
					if(imaginarys.contains(now)){
						// 如果是虚拟
						sb.append(now);
						String suffixInt=StringUtilPlus.getSuffixInt(now);
						sb.append(String.format("{rtn.coz=%s;}",suffixInt));
					}else{
						// 用set还是用add?
						String addset=StringUtilPlus.setOrAdd(start,rule);
						// 收集Med
						Med med=new Med();
						med.setName(addset+StringUtilPlus.ucword(now));
						med.setType(now);
						if(!StringUtil.isUpperCase(now,"_")){
							sb.append(String.format("(x%d=%s{rtn.%s%s(x%d);})",i,now,addset,StringUtilPlus.ucword(now),
									i));
							med.setType(StringUtilPlus.ucword(now));
						}else{
							sb.append(String.format("(x%d=%s{rtn.%s%s($x%d.text);})",i,now,addset,StringUtilPlus
									.ucword(now),i));
							med.setType("String");
						}
						i++;
						clz.addMed(med);
					}
					// System.err.println(m.group());
				}
			}
			write(sb.toString()+"\n");
		}
		if(rule.startsWith(":")){
			write(":");
			formats.add(clz.getName()+"--->"+rule);
		}
		if(rule.startsWith("|")){
			write("|");
			formats.add(clz.getName()+"--->"+rule);
		}
	}
	private static boolean isRule(String rule){
		if(rule.trim().startsWith(":")||rule.trim().startsWith("|")||rule.trim().startsWith(";")
				||rule.trim().startsWith("->"))
			return true;
		return false;
	}
	private static void init(){
		try{
			File grammer=new File(from);
			if(!grammer.exists()){
				grammer.createNewFile();
			}
			reader=new BufferedReader(new FileReader(grammer));
			File imaginary=new File(to);
			if(!imaginary.exists()){
				imaginary.createNewFile();
			}
			writer=new BufferedWriter(new FileWriter(imaginary));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		initImaginarys();
		init();
		analyse();
		for(String format:formats){
			System.out.println(format);
		}
		CodeDomGen.parse("code\\com\\cozilyworks\\cozily\\codedom\\impl",clzs);
	}
	private static void initImaginarys(){
		try{
			File imaginaryFile=new File(imaginaryTxt);
			if(!imaginaryFile.exists()){
				imaginaryFile.createNewFile();
			}
			BufferedReader imaginaryReader=new BufferedReader(new FileReader(imaginaryFile));
			String line=imaginaryReader.readLine();
			while(line!=null){
				imaginarys.add(line.substring(0,line.length()-1));
				line=imaginaryReader.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void write(String line){
		try{
			System.out.print(line);
			writer.write(line);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
