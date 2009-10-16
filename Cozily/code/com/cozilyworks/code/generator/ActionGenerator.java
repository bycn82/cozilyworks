package com.cozilyworks.code.generator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * read the rules and generate the tree grammers with the actions
 *
 * @author billyuan
 *
 */
public class ActionGenerator{
	private static String path=Constants.RULES_PATH;
	private static String actionTxt=Constants.ACTION_PATH;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	private static void init(){
		try{
			File ruleFile=new File(path);
			if(!ruleFile.exists()){
				ruleFile.createNewFile();
			}
			reader=new BufferedReader(new FileReader(ruleFile));
			File actionFile=new File(actionTxt);
			if(!actionFile.exists()){
				actionFile.createNewFile();
			}
			writer=new BufferedWriter(new FileWriter(actionFile));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		init();
		String[] rules=pickRules().split(";");
		for(String rule:rules){
			System.out.println(rule);
			analyse(rule);
		}
	}
	private static void analyse(String rule){

	}
	private static String pickRules(){
		StringBuilder sb=new StringBuilder();
		try{
			String line=reader.readLine();
			boolean isRule=false;
			while(line!=null){
				if(line.trim().equalsIgnoreCase(Constants.RULES_BEGIN)){
					isRule=true;
				}
				if(line.trim().equalsIgnoreCase(Constants.RULES_END)){
					isRule=false;
				}
				if(isRule){
					sb.append(line);
				}
				line=reader.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return sb.toString().replace(Constants.RULES_BEGIN,"");
	}
	private static void writeImaginry(String line){
		try{
			writer.write(line+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
