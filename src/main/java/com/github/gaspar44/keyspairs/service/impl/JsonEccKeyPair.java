package com.github.gaspar44.keyspairs.service.impl;

import org.codehaus.jackson.annotate.JsonProperty;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPair;

public class JsonEccKeyPair extends JsonKeyPair {
	
	@JsonProperty("named_curve") 
	private String namedCurve;
	
	public JsonEccKeyPair() {}
	
	public JsonEccKeyPair(String id, String namedCurve) {
		super(id);
		this.namedCurve = namedCurve;
	}

	public String getNamedCurve() {
		return this.namedCurve;
	}

}