package com.github.gaspra44.keypairs.service.json;

import java.util.concurrent.ThreadLocalRandom;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.github.gaspar44.keyspairs.service.api.JsonKeyPair;
import com.github.gaspar44.keyspairs.service.api.JsonKeyPairRequest;
import com.github.gaspar44.keyspairs.service.api.KeyPair;
import com.github.gaspar44.keyspairs.service.impl.JsonEccKeyPair;
import com.github.gaspar44.keyspairs.service.impl.JsonRsaKeyPair;
import com.github.gaspar44.keyspairs.service.rest.KeyStoreService;

public class JsonKeyPairTest {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private String jsonEcc = "{ \"type\" : \"ecc\", \"named_curve\" : \"prime2\""
			+ "}";
	
	@Test
	@Ignore
	public void deserializeTest() throws Exception {
		KeyPair keyPair = objectMapper.readValue(jsonEcc, JsonKeyPair.class);
		Assert.assertNotNull(keyPair);
		Assert.assertTrue(keyPair instanceof JsonEccKeyPair);
		JsonEccKeyPair ecc = (JsonEccKeyPair)keyPair;
		Assert.assertEquals("prime2", ecc.getNamedCurve());
	}
	
	@Test
	@Ignore
	public void jsonKeyPairRequestVerifyTypeTest() throws Exception {
		KeyPair keyPair = (KeyPair) objectMapper.readValue(jsonEcc, JsonKeyPairRequest.class);
		Assert.assertNotNull(keyPair);
		Assert.assertTrue(keyPair instanceof JsonKeyPairRequest);
		JsonEccKeyPair ecc = (JsonEccKeyPair)keyPair;
		Assert.assertEquals("prime2", ecc.getNamedCurve());
		
	}
	
	@Test
	@Ignore
	public void jsonKeyPairVerifyTypeTest() throws Exception {
		KeyPair keyPair = (KeyPair) objectMapper.readValue(jsonEcc, JsonKeyPairRequest.class);
		Assert.assertNotNull(keyPair);
		Assert.assertTrue(keyPair instanceof KeyPair);
		JsonEccKeyPair ecc = (JsonEccKeyPair)keyPair;
		Assert.assertTrue(ecc instanceof KeyPair);
		Assert.assertEquals("prime2", ecc.getNamedCurve());
		
	}
	
	@Test
	@Ignore
	public void jsonKeyPairGetKeysTest() throws Exception {
		KeyPair keyPair = (KeyPair) objectMapper.readValue(jsonEcc, JsonKeyPairRequest.class);
		Assert.assertNotNull(keyPair);
		Assert.assertTrue(keyPair instanceof JsonEccKeyPair);
		
		JsonEccKeyPair ecc = (JsonEccKeyPair)keyPair;
		KeyPair eccFull = new JsonEccKeyPair(generateKeyPairId(),ecc.getNamedCurve());
		
		Assert.assertNotNull(eccFull.getId());
		Assert.assertNotNull(eccFull.getPrivateKey());
		Assert.assertNotNull(eccFull.getPublicKey());
		
	}
	
	@Test
	@Ignore
	public void transformJsonKeyPairRequestIntoJsonEccKeyPairTest() throws Exception {
		JsonKeyPairRequest request = objectMapper.readValue(jsonEcc, JsonKeyPairRequest.class);
		Assert.assertNotNull(request);
		KeyStoreService keyStore = new KeyStoreService();
		KeyPair finalGeneratedKeyPair = keyStore.generateKeyPair(request);		
		Assert.assertNotNull(finalGeneratedKeyPair);
		
		JsonEccKeyPair ecc = (JsonEccKeyPair) finalGeneratedKeyPair;
		Assert.assertTrue(finalGeneratedKeyPair instanceof JsonKeyPairRequest);
		
		Assert.assertNotNull(ecc.getId());
		Assert.assertNotNull(ecc.getPrivateKey());

		Assert.assertEquals("prime2", ecc.getNamedCurve());
				
	}
	
	@Test
	@Ignore
	public void transformJsonKeyPairRequestIntoJsonRsaKeyPairTest() throws Exception {
		String jsonRsa = "{ \"type\" : \"rsa\", \"key_size\" : \"1024\""
				+ "}";
		
		JsonKeyPairRequest request = objectMapper.readValue(jsonRsa, JsonKeyPairRequest.class);
		Assert.assertNotNull(request);
		KeyStoreService keyStore = new KeyStoreService();
		KeyPair finalGeneratedKeyPair = keyStore.generateKeyPair(request);		
		Assert.assertNotNull(finalGeneratedKeyPair);
		
		JsonRsaKeyPair rsa = (JsonRsaKeyPair) finalGeneratedKeyPair;
		Assert.assertTrue(finalGeneratedKeyPair instanceof JsonKeyPairRequest);
		
		Assert.assertNotNull(rsa.getId());
		Assert.assertNotNull(rsa.getPrivateKey());

		Assert.assertEquals("1024", rsa.getKeySize());
				
	}
	
	@Test
	@Ignore
	public void getKeyPairFromKeyStoreTest() throws Exception {
		
		JsonKeyPairRequest request = objectMapper.readValue(jsonEcc, JsonKeyPairRequest.class);
		Assert.assertNotNull(request);
		KeyStoreService keyStore = new KeyStoreService();
		KeyPair finalGeneratedKeyPair = keyStore.generateKeyPair(request);		
		Assert.assertNotNull(finalGeneratedKeyPair);
		JsonEccKeyPair ecc = (JsonEccKeyPair) finalGeneratedKeyPair;
		
		Assert.assertNotNull(ecc.getId());
		Assert.assertNotNull(ecc.getPrivateKey());
		Assert.assertNotNull(ecc.getPublicKey());
		Assert.assertNotNull(ecc.getNamedCurve());
		
		String id = ecc.getId();
		KeyPair storedKey = keyStore.getKeyPairFromStoreById(id);
		
		Assert.assertFalse(storedKey instanceof JsonRsaKeyPair);
		JsonEccKeyPair storedKeyEcc = (JsonEccKeyPair)storedKey;
		
		Assert.assertEquals(storedKeyEcc.getId(), ecc.getId());
		Assert.assertEquals(storedKeyEcc.getPrivateKey(), ecc.getPrivateKey());
		Assert.assertEquals(storedKeyEcc.getPublicKey(),ecc.getPublicKey());
		Assert.assertEquals(storedKeyEcc.getNamedCurve(), ecc.getNamedCurve());		
		
	}
	
	private String generateKeyPairId() {
		int randomGenerateId = ThreadLocalRandom.current().nextInt(0,10001);
		return String.valueOf(randomGenerateId);
	}
	
}
