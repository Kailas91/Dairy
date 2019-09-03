package com.uks.jvs.test.ass3;
/**
 * Date:5/07/2019
 * Assignment: 3 Evaluation test
 * Task: Encoding and Decoding using Base 64
 *
 * @author Kailas
 */
import java.util.Base64;

//Base64 Encoding and Decoding in Java
class EncodingAndDeco {
	public static void main(String[] args) {
		String string = "Unikaihatsu Software";
		// encode string using Base64 encoder
		Base64.Encoder encoder = Base64.getEncoder();
		String encoded = encoder.encodeToString(string.getBytes());
		System.out.println("Encoded Data: " + encoded);

		// decode the encoded data
		Base64.Decoder decoder = Base64.getDecoder();
		String decoded = new String(decoder.decode(encoded));
		System.out.println("Decoded Data: " + decoded);
	}
}