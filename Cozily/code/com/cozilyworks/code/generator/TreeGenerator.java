package com.cozilyworks.code.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.util.StringUtilPlus;

/**
 * read the rules and generate the tree grammers with the actions
 * 
 * @author billyuan
 */
public class TreeGenerator{
	private static String rulePath=Constants.RULES_PATH;
	private static String newRulePath=Constants.NEW_RULES_PATH;
	private static String imaginaryPath=Constants.IMAGINARY_PATH;
	public static BufferedWriter writer,writeImaginary;
	public static BufferedReader reader;
	public static String nowRuleName="";
	public static int i=0;
	public static List<String> imaginarys=new ArrayList<String>();
	private static void init(){
		try{
			File ruleFile=new File(rulePath);
			if(!ruleFile.exists()){
				ruleFile.createNewFile();
			}
			reader=new BufferedReader(new FileReader(ruleFile));
			File actionFile=new File(newRulePath);
			if(!actionFile.exists()){
				actionFile.createNewFile();
			}
			writer=new BufferedWriter(new FileWriter(actionFile));
			File imaginary=new File(imaginaryPath);
			if(!imaginary.exists()){
				imaginary.createNewFile();
			}
			writeImaginary=new BufferedWriter(new FileWriter(imaginary));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		init();
		List<String> rules=pickRules();
		analyse(rules);
		writeImaginary();
	}
	private static void writeImaginary(){
		try{
			for(String imaginary:imaginarys){
				writeImaginary.write(imaginary+"\n");
			}
			writeImaginary.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void analyse(List<String> rules){
		for(String rule:rules){
			if(isRule(rule)){
				doRule(rule);
			}else{
				doRuleName(rule);
			}
		}
		try{
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void doRuleName(String ruleName){
		try{
			nowRuleName=ruleName;
			writer.write(ruleName+"\n");
			i=0;
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void doRule(String rule){
		try{
			writer.write(rule+"\n");
			if(!rule.trim().equals(";")){
				rule=StringUtilPlus.clean(rule);
				String tree=String.format("->^(%s %s)\n",nowRuleName.toUpperCase().trim()+i,removeFirstColon(rule));
				writer.write(tree);
				imaginarys.add(nowRuleName.toUpperCase().trim()+i+";");
				i++;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static Object removeFirstColon(String rule){
		rule=rule.trim();
		String colon=rule.substring(0,1);
		if(colon.equals(":")||colon.equals("|")){
			rule=rule.substring(1);
		}
		return rule;
	}
	private static boolean isRule(String rule){
		if(rule.trim().startsWith(":")||rule.trim().startsWith("|")||rule.trim().startsWith(";"))
			return true;
		return false;
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
					if(!line.startsWith("//")){
						if(line.trim().length()!=0){
							rules.add(line);
						}
					}
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
