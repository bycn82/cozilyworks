package com.cozilyworks.code.generator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * this class can read all the imaginary node from the grammer file and write
 * all of them into a txt file
 *
 * @author billyuan
 *
 */
public class ImaginaryPicker{
	private static String path=Constants.GRAMMER_PATH;
	private static String imaginaryTxt=Constants.IMAGINARY_PATH;
	public static BufferedWriter writer;
	public static BufferedReader reader;
	public static void pick(String path){
		try{
			String line=reader.readLine();
			boolean isImaginary=false;
			while(line!=null){
				if(line.trim().equalsIgnoreCase(Constants.IMAGINARY_BEGIN)){
					isImaginary=true;
				}
				if(line.trim().equalsIgnoreCase(Constants.IMAGINARY_END)){
					isImaginary=false;
				}
				if(isImaginary){
					System.out.println(line);
					writeImaginry(line);
				}
				line=reader.readLine();
			}
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void init(){
		try{
			File grammer=new File(path);
			if(!grammer.exists()){
				grammer.createNewFile();
			}
			reader=new BufferedReader(new FileReader(grammer));
			File imaginary=new File(imaginaryTxt);
			if(!imaginary.exists()){
				imaginary.createNewFile();
			}
			writer=new BufferedWriter(new FileWriter(imaginary));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		init();
		pick(path);
	}
	private static void writeImaginry(String line){
		try{
			writer.write(line+"\n");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
