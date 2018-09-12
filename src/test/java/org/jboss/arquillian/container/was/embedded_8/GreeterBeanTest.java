package org.jboss.arquillian.container.was.embedded_8;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.was.embedded_8.ejb.GreeterBean;
import org.jboss.arquillian.container.was.embedded_8.ejb.MyEjb;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class GreeterBeanTest {
			
			
			  /* @Deployment
			   public static JavaArchive createDeployment() 
			   {
			      return ShrinkWrap.create(JavaArchive.class, "test.jar")
			            .addClass(GreeterBean.class);
			   } */
			   
			   @Deployment
			    public static JavaArchive createDeployment() {
			        return ShrinkWrap.create(JavaArchive.class)
			            .addClasses(GreeterBean.class, MyEjb.class);
			            //.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
			    }
			
			@Inject
			GreeterBean greeterBean;

			@Test
			public void should_create_greeting() {
			    Assert.assertEquals("Hello, Earthling!", greeterBean.createGreeting("Earthling"));
			    //greeter.greet(System.out, "Earthling");
			}




}
