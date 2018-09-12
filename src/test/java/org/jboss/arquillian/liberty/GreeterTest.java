package org.jboss.arquillian.liberty;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.was.embedded_8.ejb.MyEjb;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.arquillian.liberty.Greeter;
import org.jboss.arquillian.liberty.PhraseBuilder;


@RunWith(Arquillian.class)
public class GreeterTest {
		
		@Deployment
		public static JavaArchive createDeployment() {
		    JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
		        .addClasses(Greeter.class, PhraseBuilder.class, MyEjb.class)
		        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		    System.out.println(jar.toString(true));
		    return jar;
		}
		
	    @Inject
	    Greeter greeter;
	    
	    //@EJB
	    //@Inject
	    //private MyEjb instanceVariable;

		
	    @Test
	    public void should_create_greeting() {
	               
	        Assert.assertEquals("Hello, Arbind!",
	                greeter.createGreeting("Arbind"));
	            greeter.greet(System.out, "Arbind");

	    }

}
