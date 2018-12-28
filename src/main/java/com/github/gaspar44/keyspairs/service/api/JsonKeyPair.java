package com.github.gaspar44.keyspairs.service.api;

import java.util.concurrent.ThreadLocalRandom;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class JsonKeyPair extends JsonKeyPairRequest implements KeyPair {
	private String id;

	@JsonProperty("public_key")
	private String publicKey;

	@JsonProperty("private_key")
	private String privateKey;

	protected JsonKeyPair(String id) {
		this.id = id;
		this.publicKey = generatePublicKey();
		this.privateKey = generatePrivateKey();
	}

	protected JsonKeyPair() {
	}

	public String getId() {
		return id;
	}

	@Override
	public String getPublicKey() {
		return this.publicKey;
	}

	@Override
	public String getPrivateKey() {
		return this.privateKey;
	}

	private String generatePublicKey() {
		String finalPublicKey = null;

		for (int i = 0; i <= 30; i++) {
			int randomGeneratedPublicKey = ThreadLocalRandom.current().nextInt(97, 127);
			char stringedIntToAsciiFormat = (char) randomGeneratedPublicKey;
			
			if (i == 0) { 
				finalPublicKey = String.valueOf(randomGeneratedPublicKey);
			}
			
			else {
				finalPublicKey = finalPublicKey + stringedIntToAsciiFormat;
			}
			
		}

		return finalPublicKey;
	}
	
	private String generatePrivateKey() {
		String finalPrivateKey = null;  // Inicia vacía la variable
		
		for (int i = 0; i <= 30; i++) {
			int randomGeneratedPrivateKey = ThreadLocalRandom.current().nextInt(97, 127);
			char stringedIntToAsciiFormat = (char) randomGeneratedPrivateKey;
			
			if (i == 0) {
				finalPrivateKey = String.valueOf(randomGeneratedPrivateKey);
			}
			else {
				finalPrivateKey = finalPrivateKey + stringedIntToAsciiFormat;
			}

		}
		return finalPrivateKey;
	}
}