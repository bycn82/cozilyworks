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
/**
 * this class can read all the imaginary node from the grammer file and write
 * all of them into a txt file
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
		List<String> rules=pickRules();
		for(String str:rules){
			System.out.println(str);
		}
	}
	private static List<String> pickRules(){
		List<String> rules=new ArrayList<String>();
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
					//System.out.println(line);
					rules.add(line);
				}
				line=reader.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return rules;
	}
	private static void writeImaginry(String line){
		try{
			writer.write(line+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
