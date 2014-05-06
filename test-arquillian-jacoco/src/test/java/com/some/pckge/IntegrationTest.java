package com.some.pckge;

import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class IntegrationTest {

	
	@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClass (SomeClass.class)
            .addClass (IntegrationTest.class);
            //.addAsManifestResource (EmptyAsset.INSTANCE, "beans.xml");
    }
	
	@Test
	public void testSuccess() {
		SomeClass someClass = new SomeClass();
		assertEquals("Call returned unexpected int val.", someClass.someMethod(1), 1);
	}	
	
}
