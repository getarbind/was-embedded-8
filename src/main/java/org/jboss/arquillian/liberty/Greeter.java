package org.jboss.arquillian.liberty;

import java.io.PrintStream;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class Greeter {
	

		private PhraseBuilder phraseBuilder;

		@Inject
	    public Greeter(PhraseBuilder phraseBuilder) {
	        this.phraseBuilder = phraseBuilder;
	    }

	    public void greet(PrintStream to, String name) {
	        to.println(createGreeting(name));
	    }


	    public String createGreeting(String name) {
	    	return phraseBuilder.buildPhrase("hello", name);
	        //return "Hello, " + name + "!";
	    }
	

}
