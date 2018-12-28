package com.github.gaspar44.keyspairs.service.impl;

import org.codehaus.jackson.annotate.JsonProperty;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPair;

public class JsonRsaKeyPair extends JsonKeyPair {
	@JsonProperty("key_size")
	private String keySize;
	
	public JsonRsaKeyPair() {}
	
	public JsonRsaKeyPair(String ID, String keySize) {
		super(ID);
		this.keySize = keySize;
	}
	
	public String getKeySize() {
		return this.keySize;
	}
}