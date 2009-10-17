package com.cozilyworks.code.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 读出所有->开头的,然后生成tree grammer文件
 * 
 * @author billyuan
 */
public class TreePicker{
	private static String readFrom=Constants.NEW_RULES_PATH;
	private static String newTreeTxt=Constants.NEW_TREE;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static void pick(String path){
		try{
			String line=reader.readLine();
			boolean isRule=false;
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
	private static void doRuleName(String line){
		try{
			writer.write(line+"\n");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void doRule(String line){
		try{
			if(line.trim().startsWith(":")){
				writer.write(": ");
			}
			if(line.trim().startsWith("|")){
				writer.write("| ");
			}
			if(line.trim().startsWith("->")){
				writer.write(line.trim().substring(2)+"\n");
			}
			if(line.trim().startsWith(";")){
				writer.write(";\n");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static boolean isRule(String rule){
		if(rule.trim().startsWith(":")||rule.trim().startsWith("|")||rule.trim().startsWith(";")||rule.trim().startsWith("->"))
			return true;
		return false;
	}
	private static void init(){
		try{
			File newRuleFile=new File(readFrom);
			if(!newRuleFile.exists()){
				newRuleFile.createNewFile();
			}
			reader=new BufferedReader(new FileReader(newRuleFile));
			File newTreeFile=new File(newTreeTxt);
			if(!newTreeFile.exists()){
				newTreeFile.createNewFile();
			}
			writer=new BufferedWriter(new FileWriter(newTreeFile));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		init();
		pick(readFrom);
	}
}
