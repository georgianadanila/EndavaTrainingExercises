package com.endava.webfundamentals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Georgiana Danila
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PetStore {
	private Info info;
	private String apiVersion;
	private String swaggerVersion;
	
	public Info getInfo() {
		return info;
	}
	public void setInformation(Info info) {
		this.info = info;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getSwaggerVersion() {
		return swaggerVersion;
	}
	public void setSwaggerVersion(String swaggerVersion) {
		this.swaggerVersion = swaggerVersion;
	}
	
	
}
