package com.github.gaspar44.keyspairs.service.api;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;

import com.github.gaspar44.keyspairs.service.impl.JsonEccKeyPair;
import com.github.gaspar44.keyspairs.service.impl.JsonRsaKeyPair;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

@JsonSubTypes({ @Type(value = JsonEccKeyPair.class, name = "ecc"), @Type(value = JsonRsaKeyPair.class, name = "rsa") })

public abstract class JsonKeyPairRequest {
	private String type;
	
	JsonKeyPairRequest() {}
	
}
