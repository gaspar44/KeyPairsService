package com.github.gaspar44.keyspairs.service.api;

public interface KeyPairsStore {
	void insert(String id, KeyPair keyPair);
    KeyPair get(String id);
}