package org.jboss.arquillian.container.was.embedded_8.ejb;

import java.io.PrintStream;

import javax.ejb.Stateless;
//import javax.enterprise.inject.Produces;

//@Stateless
public class GreeterBean {
	
	    public void greet(PrintStream to, String name) {
	        to.println(createGreeting(name));
	    }

	    public String createGreeting(String name) {
	        return "Hello, " + name + "!";
	    }
	    

}
