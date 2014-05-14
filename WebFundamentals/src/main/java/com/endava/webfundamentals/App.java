package com.endava.webfundamentals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.bind.api.TypeReference;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class App {
	
	public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpRequest = new HttpGet("http://petstore.swagger.wordnik.com/api/api-docs");
		HttpResponse httpResponse = httpClient.execute(httpRequest);
		
		ObjectMapper objectMapper = new ObjectMapper();
		PetStore petStore = objectMapper.readValue(httpResponse.getEntity().getContent(),PetStore.class);

		PrintWriter out = new PrintWriter("PetStore.html");
		out.println("<html>");
		out.println("<title>");
		out.println(petStore.getInfo().getTitle());
		out.println("</title>");
		out.println("<header>");
		out.println("Api Version "+ petStore.getApiVersion());
		out.println("</header>");
		out.println("Swagger Version " + petStore.getSwaggerVersion());
		out.println("<p>");
		out.println(petStore.getInfo().getDescription());
		out.println("</p>");
		out.println("<p>");
		out.println(petStore.getInfo().getContact());
		out.println("</p>");
		out.println(petStore.getInfo().getLicense());
		out.println(petStore.getInfo().getLicenseUrl());
		out.println("<p>");
		out.println(petStore.getInfo().getTermsOfServiceUrl());
		out.println("</p>");
		out.println("</html>");
		
		out.close();
	}	
}
