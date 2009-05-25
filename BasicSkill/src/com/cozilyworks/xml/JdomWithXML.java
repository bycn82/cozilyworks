package com.cozilyworks.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JdomWithXML{
	public static void main(String[] args){
		try{
			SAXBuilder builder=new SAXBuilder();
			Document doc=builder.build(new File("D:\\WORKSPACES\\WORKS\\NewWhitesand\\.classpath"));
			Element root=doc.getRootElement();
			List elements=root.getChildren();
			for(int i=0;i<elements.size();i++){
				Element element=(Element)elements.get(i);
				String path=element.getAttribute("path").getValue();
				if(path.startsWith("E:")){
					String name=path.substring(7);
					File to=new File("D:\\WORKSPACES\\WORKS\\NewWhitesand\\www\\WEB-INF\\lib\\"+name);
					File from=new File(path);
					copyFile(from,to);
				}
			}
		}catch(JDOMException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void copyFile(File in,File out) throws Exception{
		FileInputStream fis=new FileInputStream(in);
		FileOutputStream fos=new FileOutputStream(out);
		byte[] buf=new byte[1024];
		int i=0;
		while((i=fis.read(buf))!=-1){
			fos.write(buf,0,i);
		}
		fis.close();
		fos.close();
	}
}
