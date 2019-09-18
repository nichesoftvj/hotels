package com.pyt.supplier.configuration;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SignatureGenerator {

	@Value("${apiKey}")
	private String apiKey;

	@Value("${secret}")
	private String secret;

	@Value("${sha}")
	private String sha;

	@Value("${charaterSetName}")
	private String charaterSetName;

	/**
	 * Generate the Signature using Apikey and Secret Key with current Timestamp
	 * 
	 * @return
	 */
	public String getSignature() {

		Long timestamp = (new Date().getTime() / 1000);
		String signature = null;
		try {
			String toBeHashed = apiKey + secret + timestamp;
			MessageDigest md = MessageDigest.getInstance(sha);
			byte[] bytes = md.digest(toBeHashed.getBytes(charaterSetName));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			signature = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException : " + e.getMessage());
		} catch (UnsupportedEncodingException en) {
			log.error("UnsupportedEncodingException : " + en.getMessage());
		}
		String authHeaderValue = "EAN APIKey=" + apiKey + ",Signature=" + signature + ",timestamp=" + timestamp;
		log.info("Generated Signature: " + authHeaderValue);
		return authHeaderValue;
	}
}
