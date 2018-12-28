package com.github.gaspar44.keyspairs.service.impl;

import java.util.concurrent.ThreadLocalRandom;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPairRequest;
import com.github.gaspar44.keyspairs.service.api.KeyPair;

public class KeyPairsFactoryImpl implements KeyPairsFactory {
	public KeyPair create(JsonKeyPairRequest keyPairRequest) throws Exception {
		String idToSet = generateKeyPairId();
		if (keyPairRequest instanceof JsonEccKeyPair) {
			JsonEccKeyPair ecc = (JsonEccKeyPair)keyPairRequest;
			return new JsonEccKeyPair(idToSet,ecc.getNamedCurve());
		}
		else if (keyPairRequest instanceof JsonRsaKeyPair) {
			JsonRsaKeyPair rsa = (JsonRsaKeyPair)keyPairRequest;
			return new JsonRsaKeyPair(idToSet,rsa.getKeySize());
		}
		throw new UnsupportedKeyFormat();
	}
	
	private static String generateKeyPairId() {
		int randomGenerateId = ThreadLocalRandom.current().nextInt(0,10001);
		return String.valueOf(randomGenerateId);
	}
}
