package com.cozilyworks.code.generator;

import java.util.ArrayList;
import java.util.List;

public class Clz{
	private String name;
	private List<Med> meds=new ArrayList<Med>();
	private List<String> formats=new ArrayList<String>();
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public List<Med> getMeds(){
		return meds;
	}
	public void addMed(Med med){
		this.meds.add(med);
	}
	public List<String> getFormats(){
		return formats;
	}
	public void addFormat(String f){
		this.formats.add(f);
	}
}
