package com.github.gaspar44.keyspairs.service.impl;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPairRequest;
import com.github.gaspar44.keyspairs.service.api.KeyPair;

public interface KeyPairsFactory {
	KeyPair create(JsonKeyPairRequest keyPairRequest) throws Exception;
}
