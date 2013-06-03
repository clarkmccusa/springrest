package com.mcc.springrest;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyTest {

	@Before()
	public void setUp(){
		System.out.println("Starting Jetty server...");
		Server server = new Server(8099);
		server.setStopAtShutdown(true);
		
		WebAppContext context = new WebAppContext();
		context.setContextPath("springrest");
		context.setResourceBase("/src/main/webapp/WEB-INF");
		context.setClassLoader(getClass().getClassLoader());
		server.addHandler(context);
		
		
	}
	
	@Test
	public void testJettyServer(){
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://localhost:8099/springrest/books");
		
		
		try{
			HttpResponse response = client.execute(get);
			StatusLine status = response.getStatusLine();
			System.out.println("Status line:"+status.getReasonPhrase());
			
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}
	
}
