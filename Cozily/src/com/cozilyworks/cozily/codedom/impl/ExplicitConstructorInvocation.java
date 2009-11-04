package com.cozilyworks.cozily.codedom.impl;

import java.util.ArrayList;
import java.util.List;
import com.cozilyworks.cozily.codedom.*;

public class ExplicitConstructorInvocation extends CodeDocument{
	public NonWildcardTypeArguments nonwildcardtypearguments;
	public void setNonWildcardTypeArguments(NonWildcardTypeArguments t){
		this.nonwildcardtypearguments=t;
	}
	public ThisOrSuper thisorsuper;
	public void setThisOrSuper(ThisOrSuper t){
		this.thisorsuper=t;
	}
	public Arguments arguments;
	public void setArguments(Arguments t){
		this.arguments=t;
	}
	public Primary primary;
	public void setPrimary(Primary t){
		this.primary=t;
	}
	public void visit(){
		if(coz==0){
			//"nonWildcardTypeArguments? thisOrSuper arguments ';'";
			format("%s %s %s;",this.nonwildcardtypearguments,this.thisorsuper,this.arguments);
		}
		if(coz==1){
			//"primary '.' nonWildcardTypeArguments? 'super' arguments ';'";
			format("%s.%s super %s;",this.primary,this.nonwildcardtypearguments,this.arguments);
		}
	}
}
