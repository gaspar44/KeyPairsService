package com.github.gaspar44.keyspairs.service.impl;

@SuppressWarnings("serial")
public class UnsupportedKeyFormat extends Exception {
	public UnsupportedKeyFormat() {
		super("unsupported key format. Must use: ecc or rsa");
	}
}
