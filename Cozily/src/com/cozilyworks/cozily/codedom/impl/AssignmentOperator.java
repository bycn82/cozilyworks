package com.cozilyworks.cozily.codedom.impl;
import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;
public class AssignmentOperator extends CodeDocument{
	private String eqStr;
	public void setEQ(String t){
		this.eqStr=t;
	}
	private String pluseqStr;
	public void setPLUSEQ(String t){
		this.pluseqStr=t;
	}
	private String subeqStr;
	public void setSUBEQ(String t){
		this.subeqStr=t;
	}
	private String stareqStr;
	public void setSTAREQ(String t){
		this.stareqStr=t;
	}
	private String slasheqStr;
	public void setSLASHEQ(String t){
		this.slasheqStr=t;
	}
	private String ampeqStr;
	public void setAMPEQ(String t){
		this.ampeqStr=t;
	}
	private String bareqStr;
	public void setBAREQ(String t){
		this.bareqStr=t;
	}
	private String careteqStr;
	public void setCARETEQ(String t){
		this.careteqStr=t;
	}
	private String percenteqStr;
	public void setPERCENTEQ(String t){
		this.percenteqStr=t;
	}
	private String ltStr;
	public void setLT(String t){
		this.ltStr=t;
	}
	private String gtStr;
	public void setGT(String t){
		this.gtStr=t;
	}
	public void visit(){
		if(coz==0){
			// "EQ";
			add(eqStr);
		}
		if(coz==1){
			// "PLUSEQ";
			add(pluseqStr);
		}
		if(coz==2){
			// "SUBEQ";
			add(subeqStr);
		}
		if(coz==3){
			// "STAREQ";
			add(stareqStr);
		}
		if(coz==4){
			// "SLASHEQ";
			add(slasheqStr);
		}
		if(coz==5){
			// "AMPEQ";
			add(ampeqStr);
		}
		if(coz==6){
			// "BAREQ";
			add(bareqStr);
		}
		if(coz==7){
			// "CARETEQ";
			add(careteqStr);
		}
		if(coz==8){
			// "PERCENTEQ";
			add(percenteqStr);
		}
		if(coz==9){
			// "LT LT EQ";
			format("%s%s%s",this.ltStr,this.ltStr,this.eqStr);
		}
		if(coz==10){
			// "GT GT GT EQ";
			format("%s%s%s%s",this.gtStr,this.gtStr,this.gtStr,this.eqStr);
		}
		if(coz==11){
			// "GT GT EQ";
			format("%s%s%s",this.gtStr,this.gtStr,this.eqStr);
		}
	}
}