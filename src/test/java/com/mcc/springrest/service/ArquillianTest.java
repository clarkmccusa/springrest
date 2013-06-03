package com.mcc.springrest.service;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianTest {

	public static final String EXPECTED_JSON = "[{\"id\":1,\"title\":\"Book1 Title\",\"author_name\":\"Joe\"},{\"id\":2,\"title\":\"Book2 Title\",\"author_name\":\"Sally\"},{\"id\":3,\"title\":\"Book3 Title\",\"author_name\":\"Tim\"}]";
	
	@Deployment
	public static WebArchive createDeployment(){
		WebArchive war = ShrinkWrap.create(WebArchive.class, "springrest.war")
				.addPackages(true,"com.mcc.springrest")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/spring/root-context.xml"),"/spring/root-context.xml")
				.addAsWebInfResource(new File("src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"), "/spring/appServlet/servlet-context.xml")
				.setWebXML(new File("src/main/webapp","WEB-INF/web.xml"));
		return war;
	}
	
	@Test
	public void testBooks(){
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://localhost:9091/springrest/books");
		try{
			HttpResponse response = client.execute(get);
			String responseString = IOUtils.toString(response.getEntity().getContent());
			assertEquals( EXPECTED_JSON, responseString );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
