package com.cozilyworks.generator;

import java.util.ArrayList;
import java.util.List;

public class Clz{
	private String name;
	private List<Med> meds=new ArrayList<Med>();
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
}
