package com.github.gaspar44.keyspairs.service.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPairRequest;
import com.github.gaspar44.keyspairs.service.api.KeyPair;
import com.github.gaspar44.keyspairs.service.api.KeyPairsStore;
import com.github.gaspar44.keyspairs.service.impl.KeyPairsFactory;

@Path("/restService")
public class KeyStoreService /*extends Application*/ {

	@Inject
	private KeyPairsStore keyStore;

	@Inject
	private KeyPairsFactory keyPairsFactory;

	@POST
	@Path("/keyPairs")
	@Produces("application/json")
	@Consumes("application/json")
	public KeyPair generateKeyPair(JsonKeyPairRequest keyPairRequest) throws Exception {
		KeyPair generatedKeyPair = keyPairsFactory.create(keyPairRequest);
		keyStore.insert(generatedKeyPair.getId(), generatedKeyPair);
		return generatedKeyPair;
	}

	@GET
	@Path("/keyPairs/{id}")
	@Produces("application/json")
	public KeyPair getKeyPairFromStoreById(@PathParam("id") String id) {
		return keyStore.get(id);
		
	}
	
}