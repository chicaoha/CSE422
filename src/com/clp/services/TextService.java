package com.clp.services;

import java.nio.charset.Charset;
import java.util.Random;

public class TextService {
	public String hashMD5(String text) {
		return text;
	}

	public String generateCode() {
		byte[] array = new byte[7];
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));
		return generatedString;
	}
}
