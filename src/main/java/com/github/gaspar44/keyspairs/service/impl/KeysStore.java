package com.github.gaspar44.keyspairs.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.gaspar44.keyspairs.service.api.KeyPair;
import com.github.gaspar44.keyspairs.service.api.KeyPairsStore;

public class KeysStore implements KeyPairsStore {
	static private Map<String, KeyPair> keysStock = new HashMap<String,KeyPair>();
	
	public void insert(String id, KeyPair keyPair) {
		if (!keysStock.containsKey(id)) {
			keysStock.put(id, keyPair);
			
		}
	}

	@Override
	public KeyPair get(String id) {
		for(Map.Entry<String, KeyPair> entry : keysStock.entrySet()) {
			String clave = entry.getKey();
			System.out.println(clave);
		}
		if (!keysStock.containsKey(id)) {
			return null;
		}
		
		else {
			return keysStock.get(id);
		}
	}
}