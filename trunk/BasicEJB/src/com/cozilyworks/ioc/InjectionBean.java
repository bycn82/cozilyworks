package com.cozilyworks.ioc;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote (Injection.class)
public class InjectionBean implements Injection { 
    @EJB (beanName="RemoteSay") SayAction sayAction;
    public String SayHello() {  
        return sayAction.SayHello("HaHa");
    }
}
