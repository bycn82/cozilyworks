package com.cozilyworks.code.generator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * read and return the imaginary nodes in a list
 * @author billyuan
 *
 */
public class ImaginaryReader{
	private static BufferedReader reader;
	private static String path=Constants.IMAGINARY_PATH;
	public static void main(String[] arg){
		List<String> nodes=readImaginary();
		for(String node:nodes)
			System.out.println(node);
	}
	public static void init(){
		try{
			reader=new BufferedReader(new FileReader(new File(path)));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	public static List<String> readImaginary(){
		init();
		try{
			List<String> imaginaries=new ArrayList<String>();
			String line;
			line=reader.readLine();
			while(line!=null){
				line=line.trim();
				if(!line.equalsIgnoreCase(Constants.IMAGINARY_BEGIN)&&!line.equalsIgnoreCase(Constants.IMAGINARY_END)
						&&!line.equalsIgnoreCase("")){
					imaginaries.add(line.replace(";",""));
				}
				line=reader.readLine();
			}
			return imaginaries;
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
